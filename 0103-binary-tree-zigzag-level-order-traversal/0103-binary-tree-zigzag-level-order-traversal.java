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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> queue= new ArrayDeque<>();
        queue.offer(root);
        boolean flag =false;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list1 = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                TreeNode curr;
                if (flag) {
                    curr = queue.pollLast();
                    if (curr.right != null) queue.offerFirst(curr.right);
                    if (curr.left != null) queue.offerFirst(curr.left);
                } else {
                    curr = queue.pollFirst();
                    if (curr.left != null) queue.offerLast(curr.left);
                    if (curr.right != null) queue.offerLast(curr.right);
                }
                list1.add(curr.val);
            }
            flag=!flag;
            list.add(list1);
        }
        return list;
    }
}