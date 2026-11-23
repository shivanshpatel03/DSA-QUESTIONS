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
    int index;
    private TreeNode buildtree(int[] postorder,int start , int end){
        if(start>end){
            return null;
        }
        int root=map.get(postorder[index]);
        TreeNode treeroot=new TreeNode(postorder[index--]);

        treeroot.right=buildtree(postorder ,root+1,end);
        treeroot.left=buildtree(postorder ,start,root-1);
        
        return treeroot;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildtree(postorder,0,inorder.length-1);
        
    }
}