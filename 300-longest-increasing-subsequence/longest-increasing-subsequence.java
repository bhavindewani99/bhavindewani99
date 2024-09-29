class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return searchSolution(n, nums);
        //return recursion(n-1, Integer.MAX_VALUE, nums);
    }

    private int recursion(int index, int last, int[] nums){
        if(index==0) return nums[0]<last ? 1 : 0;
        int not_take = recursion(index-1, last, nums);
        int take = 0;
        if(last>nums[index]){
            take = 1 + recursion(index-1, nums[index], nums);
        }
        return Math.max(take, not_take);
    }

    // n log n Solution

    private int searchSolution(int n, int[] nums){
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>res.get(res.size()-1)){
                res.add(nums[i]);
            }else{
                int index = binarySearch(nums[i], res);
                res.set(index,nums[i]);
            }
        }
        return res.size();
    }

    private int binarySearch(int element, List<Integer> res){
        int low = 0;
        int high =res.size()-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(res.get(mid)==element) return mid;
            else if(res.get(mid)<element){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}