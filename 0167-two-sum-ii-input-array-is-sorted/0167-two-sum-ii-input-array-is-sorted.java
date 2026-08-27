class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] arr=new int[2];
        if(n<2) return arr;
        int start =0;
        int end =n-1;
        while(start<end){
            int k = numbers[start]+numbers[end];
            if(k==target){
                arr[0]=start+1;
                arr[1]=end+1;
                return arr;
            }
            else if(k<target){
                start++;
            }
            else{
                end--;
            }
        }
        return arr;
    }
}