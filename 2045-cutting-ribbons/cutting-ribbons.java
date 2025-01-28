class Solution {
    public int maxLength(int[] ribbons, int k) {
        
        int mini = Integer.MIN_VALUE;

        for(int i : ribbons) mini = Math.max(i, mini);

        int low = 1;
        int high = mini;
        int result = 0;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(mid, ribbons, k)){
                result = Math.max(result, mid);
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }

        return result;
    }

    private boolean possible(int target, int[] ribbons, int k){
        long canMake = 0;
        for(int ribbon : ribbons){
            canMake += ribbon/target;
        }
        return canMake>=k;
    }
}