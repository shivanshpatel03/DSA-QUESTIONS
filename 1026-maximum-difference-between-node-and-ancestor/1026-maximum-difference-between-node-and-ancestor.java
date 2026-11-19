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
    int max=0;
    private void maxdiff(TreeNode root, TreeNode child){
        if (root == null || child == null) {
            return;
        }
        max = Math.max(max,Math.abs(root.val-child.val));
        maxdiff(root,child.left);
        maxdiff(root,child.right);
        return ;
    }
    private void iterator(TreeNode root){
        if (root == null) {
            return;
        }

        maxdiff(root,root.left);
        maxdiff(root,root.right);

        iterator(root.left);
        iterator(root.right);
        return ;
    }
    public int maxAncestorDiff(TreeNode root) {
        iterator(root);
        return max;
    }
}