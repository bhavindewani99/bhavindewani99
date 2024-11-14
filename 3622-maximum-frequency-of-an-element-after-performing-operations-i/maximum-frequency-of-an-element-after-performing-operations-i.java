class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxi =0;

        for(int i:nums) maxi = Math.max(i, maxi);
        int size = maxi+k+2;

        int[] freq = new int[size];
        for(int i:nums) freq[i]++;

        int[] prefix = new int[size];
        prefix[0]= freq[0];
        for(int i=1;i<size;i++){
            prefix[i] = prefix[i-1]+ freq[i];
        }

        int result = 0;
        for(int element = 0; element<size;element++){
            int left = Math.max(0, element-k);
            int right = Math.min(size-1,element+k);
            int totalInRange = prefix[right] - (left > 0 ? prefix[left-1] : 0);
            int canAdjust = totalInRange - freq[element];
            int total = freq[element] + Math.min(canAdjust, numOperations);
            result = Math.max(result, total);
        }
        return result;
    }
}