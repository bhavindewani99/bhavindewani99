class Solution {
    public long maximumTripletValue(int[] nums) {
        
        int n = nums.length;
        int[] difference = new int[n];
        int maximum = nums[0];

        for(int i=1;i<n;i++){
            if(maximum > nums[i]){
                difference[i] = maximum - nums[i];
            }else{
                maximum = nums[i];
            }
        }

        // 0, 6, 11, 10, 5

        for(int i=1;i<n;i++){
            difference[i] = Math.max(difference[i], difference[i-1]);
        }

        long result = 0;
        for(int i=2;i<n;i++){
            result = Math.max(result, nums[i] * 1l * difference[i-1]);
        }

        return result;
    }
}