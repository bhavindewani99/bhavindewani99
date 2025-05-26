class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        
        Arrays.sort(queries, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> availableQueries = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        PriorityQueue<Integer> usedQueries = new PriorityQueue<>(); // minHeap
        int queryIndex = 0, operation = 0, queryLength = queries.length;

        for(int i=0;i<nums.length;i++){
            // Add all the queries starting at this index in the availableQueries pool
            while(queryIndex < queryLength && queries[queryIndex][0] == i){
                availableQueries.offer(queries[queryIndex][1]); // add only ending time
                queryIndex++;
            }

            nums[i] -= usedQueries.size();

            // Add queries from availableQueries to usedQueries if required
            while(nums[i]>0 && availableQueries.isEmpty()==false && availableQueries.peek()>=i){
                usedQueries.offer(availableQueries.poll());
                operation++;
                nums[i]--;
            }

            if(nums[i] > 0) return -1; // means we cannot satisfy this index

            // Remove all the queries from usedQueries ending at this index
            while (usedQueries.isEmpty()==false && usedQueries.peek()==i) {
                usedQueries.poll();
            }
        }
        return queryLength - operation;
    }
}