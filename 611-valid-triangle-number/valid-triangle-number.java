class Solution {
    public int triangleNumber(int[] nums) {
        
        int triplets = 0;
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int sum = nums[i] + nums[j];
                triplets += binarySearch(nums, j, n, sum);
            }
        }
        return triplets;
    }

    private int binarySearch(int[] nums, int index, int n, int sum){
        int left = index+1;
        int right = n - 1;
        int resultIndex = -1;

        while (left<=right) {
            int mid = (left + right)/2;
            if(nums[mid] < sum){
                resultIndex = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return resultIndex==-1 ? 0 : resultIndex-index;
    }
}