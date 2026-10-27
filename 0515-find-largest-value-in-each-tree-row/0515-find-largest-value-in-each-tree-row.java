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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int k=queue.size();
            int max= Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                TreeNode currnode=queue.poll();
                max=Math.max(currnode.val,max);
                if(currnode.left!=null){
                    queue.offer(currnode.left);
                }
                if(currnode.right!=null){
                    queue.offer(currnode.right);
                }
            }
            list.add(max);
        }

        return list;
    }
}