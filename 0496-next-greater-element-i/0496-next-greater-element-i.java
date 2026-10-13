class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack= new ArrayDeque<>();
        for(int i =0 ;i<nums2.length ;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                int temp = stack.pop();
                map.put(temp,nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        int [] list= new int[nums1.length];
        for(int i=0 ; i<nums1.length ;i++){
            list[i]=(map.get(nums1[i]));
            
        }
        return list;
    }
}