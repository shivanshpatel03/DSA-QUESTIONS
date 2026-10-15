class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue= new ArrayDeque<>();
        int n=tickets.length;
        for(int i=0;i<n;i++){
            queue.offer(i);
        }
        int time=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            tickets[curr]--;
            time++;
            if(tickets[curr]>0){
                queue.offer(curr);
            }
            if(curr==k&&tickets[k]==0){
                return time;
            }
        }
        return time;
    }
}