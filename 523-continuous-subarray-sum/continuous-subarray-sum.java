class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainders = new HashMap<>();
        remainders.put(0, -1);
        int total = 0;

        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            int curr = total % k;
            if(remainders.containsKey(curr)==false){
                remainders.put(curr, i);
            }else if(i - remainders.get(curr)>=2){
                return true;
            }
        }
        return false;
    }
}