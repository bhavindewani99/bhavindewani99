class Solution {
    public int minPatches(int[] nums, int n) {

        long patches = 0, maxNumber = 0;
        int index = 0;

        while(maxNumber < n){
            if(index < nums.length && maxNumber+1 >= nums[index]){
                maxNumber = maxNumber + nums[index];
                index++;
            }else{
                long nextPatchNumber = maxNumber + 1;
                maxNumber = nextPatchNumber + maxNumber;
                patches++;
            }
        }

        return (int) patches;
    }
}