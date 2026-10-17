class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n=deck.length;
        Queue<Integer> queue= new ArrayDeque<>();
        queue.offer(deck[n-1]);
        if (n > 1) {
            queue.offer(deck[n - 2]);
        }
        for (int i=n-3;i>= 0;i--){
            queue.offer(queue.poll());
            queue.offer(deck[i]);
        }
        int[] result=new int[n];
        for(int j=n-1;j>=0;j--){
            result[j]=queue.poll();
        }
        return result;
    }
}