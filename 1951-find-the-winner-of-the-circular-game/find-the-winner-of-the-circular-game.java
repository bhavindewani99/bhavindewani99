class Solution {
    public int findTheWinner(int n, int k) {
        //return recursion(n,k)+1;
        return queueSolution(n, k);
    }

    // O(n) and O(n)
    private int recursion(int n,int k){
        if(n==1) return 0;
        return (recursion(n-1,k)+k)%n;
    }

    // Queue Solution with O(n*k) and O(n)
    private int queueSolution(int n , int k){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++) queue.offer(i);

        while(queue.size()>1){
            for(int i=0;i<k-1;i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
    
}