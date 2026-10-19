class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n= nums.length;
        Deque<Integer> maxq=new ArrayDeque<>();
        Deque<Integer> minq= new ArrayDeque<>();
        int maxcount=0;
        int left=0;
        for(int right=0;right<n;right++){
            while(!maxq.isEmpty()&&maxq.peekLast()<nums[right]){
                maxq.pollLast();
            }
            maxq.offerLast(nums[right]);
            while(!minq.isEmpty()&& minq.peekLast()>nums[right]){
                minq.pollLast();
            }
            minq.offerLast(nums[right]);

            while(maxq.peekFirst()-minq.peekFirst()>limit){
                if(maxq.peekFirst()==nums[left]){
                    maxq.pollFirst();
                }
                if(minq.peekFirst()==nums[left]){
                    minq.pollFirst();
                }
                left++;
            }
            maxcount=Math.max(maxcount,right-left+1);
        }
        return maxcount;
    }
}