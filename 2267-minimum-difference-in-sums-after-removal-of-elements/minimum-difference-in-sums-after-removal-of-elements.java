class Solution { // Minimize leftSum - rightSum -> (Minimuize leftSum & maximize rightSum)
    public long minimumDifference(int[] nums) {
        
        PriorityQueue<Long> rightpq = new PriorityQueue<>(); // minHeap
        PriorityQueue<Long> leftpq = new PriorityQueue<>((a, b) -> Long.compare(b, a)); // max-heap


        int n = nums.length;
        int size = n/3;
        long[] rightMaxSum = new long[n];
        long currRightSum = 0, currLeftSum=0, result = Long.MAX_VALUE;

        for(int i = n-1;i>=0;i--){
            currRightSum += nums[i];
            rightpq.offer((long) nums[i]);

            if(rightpq.size() > size) currRightSum -= rightpq.poll();
            rightMaxSum[i] = currRightSum;
        }

        for(int i=0;i<n-size;i++){
            currLeftSum += nums[i];
            leftpq.offer((long) nums[i]);

            if(leftpq.size() > size) currLeftSum -= leftpq.poll();

            if(i+1>=size){
                long currDiff = currLeftSum - rightMaxSum[i+1];
                result = Math.min(result, currDiff);
            }
        }

        return result;

    }
}