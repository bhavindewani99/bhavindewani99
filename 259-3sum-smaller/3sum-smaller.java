class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int triplets = 0;

        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int x = target - nums[i] - nums[j];
                int index = binarySearch(nums, x, j+1);
                if(index == -1) break;
                System.out.println(nums[i] + " " + nums[j] + nums[index]);
                triplets += (index - j);
            }
        }

        return triplets;
    }

    private int binarySearch(int[] nums, int x, int low){
        int high = nums.length-1;
        int res = -1;

        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] < x){
                res = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
    }
}