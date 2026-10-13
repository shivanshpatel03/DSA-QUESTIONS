class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] sq=new long[nums.length];
        for(int i =0 ;i<nums.length;i++){
            sq[i]=(long)nums[i]*nums[i];
        }
        Arrays.sort(sq);
        long score = 0;
        int mid = sq.length / 2;

        for (int i = 0; i < mid; i++) {
            score -= sq[i];
        }

        for (int i = mid; i < sq.length; i++) {
            score += sq[i];
        }

        return score;
    }
}