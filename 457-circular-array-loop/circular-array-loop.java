class Solution {
    public boolean circularArrayLoop(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) continue; // means already visited

            boolean isPositive = nums[i]>=0;
            int slow =i;
            int fast = i;

            while(true){
                slow = findNextIndex(slow, isPositive, nums);
                if(slow == -1) break; // means self loop

                fast = findNextIndex(fast, isPositive, nums);
                if(fast!=-1) fast = findNextIndex(fast, isPositive, nums);

                if(fast==-1 || slow == fast) break;
            }

            if(slow!=-1 && slow==fast) return true;

            // mark all the visited nodes in this travesal
            slow = i;
            while(true){
                int nextIndex = findNextIndex(slow, isPositive, nums);
                if(nextIndex==-1 || nums[slow]==0) break;
                nums[slow] = 0;
                slow = nextIndex;
            }
        }

        return false;
    }

    private int findNextIndex(int currIndex, boolean isPositive, int[] nums){
        boolean direction = nums[currIndex]>=0;

        if(direction!=isPositive) return -1; // means oppotite direction
        
        int nextIndex = (currIndex + nums[currIndex] ) % nums.length;

        if(nextIndex<0) nextIndex += nums.length;

        if(nextIndex == currIndex) return -1; // means self loop

        return nextIndex;
    }
}