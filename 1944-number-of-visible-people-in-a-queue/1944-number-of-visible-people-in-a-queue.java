class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<int[]> stack= new ArrayDeque<>();
        stack.push(new int[] {heights[heights.length-1],0});
        map.put(heights[heights.length - 1], 0);
        for(int i=heights.length-2 ;i>=0;i--){
            int k=0;
            while(!stack.isEmpty()&&heights[i]>stack.peek()[0]){
                k++;
                stack.pop();
            }
            if (!stack.isEmpty()) {
                k++;
            }
            map.put(heights[i],k);
            stack.push(new int[]{heights[i],k});

        }
        while(!stack.isEmpty()){
            map.put(stack.peek()[0],stack.peek()[1]);
            stack.pop();
        }
        int[] result = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            result[i]=map.get(heights[i]);
        }
        return result;
    }
}