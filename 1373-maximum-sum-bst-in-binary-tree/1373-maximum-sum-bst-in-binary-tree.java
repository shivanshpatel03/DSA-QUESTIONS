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
    private int[] isbstsum(TreeNode node){
        if(node==null){
            return new int[]{1,Integer.MAX_VALUE, Integer.MIN_VALUE,0};
        }
        int[] left= isbstsum(node.left);
        int[] right= isbstsum(node.right);

        if(left[0]==1&& right[0]==1 && node.val <right[1]&&node.val >left[2]){
            int total = node.val + left[3] +right[3];
            max=Math.max(total,max);
            int min = Math.min(node.val,left[1]);
            int max= Math.max(node.val, right[2]);

            return new int []{1,min,max,total};
        }else{
            return new int[]{0,0,0,0};
        }

    }
    public int maxSumBST(TreeNode root) {
        isbstsum(root);
        return max;
    }
}