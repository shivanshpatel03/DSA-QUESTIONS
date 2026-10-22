class Solution {
    public int findMin(int[] nums) {
        int min=nums[0];
        int left=1;
        int right=nums.length;
        while(left<right){
            int mid =left+(right-left)/2;
            if(nums[mid]<min){
                right=mid;
                min=nums[mid];
            }else{
                left=mid+1;
            }
        }
        return min;
    }
}