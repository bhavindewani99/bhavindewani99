class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        int n = deck.length;
        int[] result = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++) queue.offer(i); // storing indexes inqueue
        Arrays.sort(deck);

        for(int card : deck){
            int index = queue.poll();
            result[index] = card;

            if(queue.isEmpty()==false){
                queue.offer(queue.poll()); // skiping the element
            }
        }

        return result;
    }
}