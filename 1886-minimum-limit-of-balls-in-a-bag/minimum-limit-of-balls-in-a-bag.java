class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int penalty = 0;
        int high = -1;
        int low =1;

        for(int i : nums) high = Math.max(high, i);

        while(low<=high){
            int mid = (low+high)/2;
            if(possible(mid, nums, maxOperations)){
                penalty = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return penalty;
    }

    private boolean possible(int maxBalls, int[] nums, int maxOperations){
        int operation = 0;
        for(int num : nums){
            operation += Math.ceilDiv(num, maxBalls) -1;
            if(operation>maxOperations) return false;
        }
        return true;
    }
}