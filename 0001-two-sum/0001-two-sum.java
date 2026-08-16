class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i=0 ; i<n ;i++){
            map.put(nums[i],i);
        }
        for(int i=0 ; i<n;i++){
            int c = target- nums[i];
            if(map.containsKey(c)&& map.get(c)!=i){
                return new int[]{map.get(c),i};
            }
        }
        return new int[]{};
    }
}