class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && i-deque.getFirst()>=k) deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]) deque.removeLast();
            deque.add(i);
            if(i>=k-1) res[index++] = nums[deque.getFirst()];
        }
        return res;
    }
}