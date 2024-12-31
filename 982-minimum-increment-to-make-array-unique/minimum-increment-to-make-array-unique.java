class Solution {
    public int minIncrementForUnique(int[] nums) {
        return linearSolution(nums);
    }

    private int linearSolution(int[] nums){
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int result = 0;

        for(int i:nums) maxi = Math.max(maxi, i);
        int[] freq = new int[maxi+n];

        for(int i:nums) freq[i]++;

        for(int i=0;i<maxi+n;i++){
            if(freq[i]>1){
                int extra = freq[i]-1;
                result += extra;
                freq[i+1] += extra;
            }
        }

        return result;
    }

    private int sortSolution(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;
        
        for(int i=1;i<n;i++){
            if(nums[i-1]>=nums[i]){
                result += Math.abs(nums[i-1]+1-nums[i]);
                nums[i] = nums[i-1] + 1;
            }
        }

        return result;
    }
}