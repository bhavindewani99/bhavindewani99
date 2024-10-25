class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index = i-1;
                break;
            }
        }
        if(index==-1) {
            revserse(nums, 0, n-1);
            return;
        }
        for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        revserse(nums, index+1, n-1);


    }

    private void revserse(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}