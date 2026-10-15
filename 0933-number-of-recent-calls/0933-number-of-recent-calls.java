class RecentCounter {
    private Queue<Integer>queue;
    public RecentCounter() {
        queue= new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        int lowerbound= t-3000;
        while(queue.peek()<lowerbound){
            queue.poll();
        }
        return queue.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */