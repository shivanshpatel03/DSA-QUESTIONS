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
    private int index;
    private TreeNode buildtree(int[] preorder,int start , int end){
        if(start>end){
            return null;
        }
        int root=map.get(preorder[index]);
        TreeNode treeroot=new TreeNode(preorder[index++]);

        treeroot.left=buildtree(preorder ,start,root-1);
        treeroot.right=buildtree(preorder ,root+1,end);

        return treeroot;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildtree(preorder,0,inorder.length-1);
    }
}