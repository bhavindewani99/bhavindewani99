class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int low, int high){
        int cnt = 0;

        if(low>=high) return cnt;
        int mid = (low+high)/2;

        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid+1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }

    private int countPairs(int[] nums, int low, int mid, int high){
        int pairs = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            pairs += (right - (mid + 1));
        }
        return pairs;
    }


    private void merge(int[] nums, int low, int mid, int high){
        
        List<Integer> arr = new ArrayList<>();
        int left =low;
        int right = mid+1;

        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                arr.add(nums[left++]);
            }else{
                arr.add(nums[right++]);
            }
        }

        while(left<=mid) arr.add(nums[left++]);

        while(right<=high) arr.add(nums[right++]);

        for(int i=low;i<=high;i++){
            nums[i] = arr.get(i-low);
        }
    }
}