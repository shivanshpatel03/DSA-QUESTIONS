class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n= nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        long sum=0;
        long max=0;
        for(int r=0; r<k ;r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            sum+= nums[r];
        }
        if(map.size()==k){
            max=sum;
        }
        for(int i =k;i<n;i++){
            int oldNum = nums[i - k];
            map.put(oldNum, map.get(oldNum) - 1);
            if (map.get(oldNum) == 0) {
                map.remove(oldNum);
            }
            sum -= oldNum;
            int newNum = nums[i];
            map.put(newNum, map.getOrDefault(newNum, 0) + 1);
            sum += newNum;
            if(map.size()==k){
                max= Math.max(max,sum);
            }
        }
        return max;
    }
}