class Solution {
    private int CanEatAll(int[] nums,int mid){
        int time=0;
        for(int i:nums){
            time+=(i+mid-1)/mid;
        }
        return time;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i:piles){
            if(i>max){
                max=i;
            }
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(CanEatAll(piles,mid)>h){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}