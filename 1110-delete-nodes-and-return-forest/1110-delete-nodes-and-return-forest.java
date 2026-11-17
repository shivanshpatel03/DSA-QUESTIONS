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
    List<TreeNode> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    private TreeNode dfs (TreeNode root){
        if(root==null){
            return null;
        }
        root.left=dfs(root.left);
        root.right= dfs(root.right);
        if(set.contains(root.val)){
            if(root.left!=null){
                list.add(root.left);
            }
            if(root.right!=null){
                list.add(root.right);
            }
            return null;
        }

         return root;

    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i =0; i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        if(dfs(root)!=null){
            list.add(root);
        }
        return list;
    }
}