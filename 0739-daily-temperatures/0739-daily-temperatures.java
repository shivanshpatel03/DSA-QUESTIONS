class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        HashMap <Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack= new ArrayDeque<>();
        for(int i=0;i<temperatures.length ;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int temp= stack.pop();
                map.put(temp,i-temp);
            }
            stack.push(i);
        }
        
            while(!stack.isEmpty()){
                map.put(stack.pop(),0);
            }
        int[] list= new int[temperatures.length];
        for(int i=0;i<temperatures.length ;i++){
            list[i]=map.get(i);
        }
        return list;
        
    }
}