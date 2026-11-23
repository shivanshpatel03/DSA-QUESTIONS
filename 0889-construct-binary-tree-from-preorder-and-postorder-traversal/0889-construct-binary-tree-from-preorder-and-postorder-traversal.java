/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    private TreeNode buildtree(int[]preorder,int[] postorder , int prestart,int preend,int poststart, int postend){
        if(prestart>preend || poststart>postend){
            return null;
        }
        TreeNode node = new TreeNode(preorder[prestart]);
        if(prestart==preend) return node;

        int leftval= preorder[prestart+1];
        int leftvalindex  =map.get(leftval);  // works for the postorder list
        int division = leftvalindex - poststart +1; // works for the preorder list

        node.left=buildtree(preorder , postorder ,prestart+1,prestart+division,poststart,leftvalindex);
        node.right= buildtree(preorder,postorder,prestart+division+1, preend,leftvalindex+1,postend-1);
        return node;

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i =0 ;i < postorder.length;i++){
            map.put(postorder[i],i);
        }
        return buildtree(preorder,postorder,0,preorder.length-1,0, postorder.length-1);
        
    }
}