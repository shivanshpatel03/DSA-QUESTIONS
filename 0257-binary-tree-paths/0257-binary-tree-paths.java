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
    List<String> list = new ArrayList<>();
    StringBuilder st=new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root== null){
            return list;
        }
        int len=st.length();
        if(root.left==null && root.right==null){
            st.append(root.val);
            list.add(st.toString());
            st.setLength(len);
            return list;
        }
        st.append(root.val + "->");
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);
        st.setLength(len);
        return list;
    }
}