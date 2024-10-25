class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n-2;i++){
            int first = nums[i];
            if(i!=0 && first==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while (j<k) {
                if(first + nums[j] + nums[k] == 0){
                    res.add(new ArrayList<>(Arrays.asList(first, nums[j], nums[k])));
                    int usedj = nums[j];
                    int usedk = nums[k];
                    while(j<k && nums[j]==usedj) j++;
                    while(k>j && nums[k]==usedk) k--;
                }else if(first + nums[j] + nums[k] > 0){
                    int usedk = nums[k];
                    while(k>j && nums[k]==usedk) k--;
                }else{
                    int usedj = nums[j];
                    while(j<k && nums[j]==usedj) j++;
                }
            }
        }
        return res;
    }
}