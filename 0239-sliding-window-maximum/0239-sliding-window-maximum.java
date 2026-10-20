class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        Deque<Integer> queue= new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        result[0]=nums[queue.peekFirst()];
        if(n==k){
            return result;
        }
        int left=0;
        for(int i=k;i<n;i++){
            if(queue.peekFirst()==left){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            result[i-k+1]=nums[queue.peekFirst()];
            left++;
        }
        return result;
    }
}