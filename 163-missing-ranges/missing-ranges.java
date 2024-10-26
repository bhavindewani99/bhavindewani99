class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) {
            res.add(new ArrayList<>(Arrays.asList(lower,upper)));
            return res;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(lower<nums[0]){
                    res.add(new ArrayList<>(Arrays.asList(lower,nums[0]-1)));
                }
            }else if((nums[i]-1)==nums[i-1]){
                continue;
            }else{
                res.add(new ArrayList<>(Arrays.asList(nums[i-1]+1,nums[i]-1)));
            }
        }
        if(upper>nums[nums.length-1]) res.add(new ArrayList<>(Arrays.asList(nums[nums.length-1]+1,upper)));
        return res;
    }
}