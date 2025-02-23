class Solution {
    public void sortColors(int[] nums) {
        int zeroP =0,oneP=0,twoP = nums.length-1;

        while (oneP<=twoP) {
            if(nums[oneP]==0){
                int temp = nums[zeroP];
                nums[zeroP] = nums[oneP];
                nums[oneP] = temp;
                zeroP++;
                oneP++;
            }else if(nums[oneP]==2){
                int temp = nums[twoP];
                nums[twoP] = nums[oneP];
                nums[oneP] = temp;
                twoP--;
            }else oneP++;
        }

    }
}