/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode lca=null;

    private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }

        boolean left= dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);

        boolean k= (root==p || root==q);
        if((left && right)||(k &&(left||right))){
            lca =root;
        }
        return k || left || right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        dfs(root,p,q);
        return lca;
    }
}