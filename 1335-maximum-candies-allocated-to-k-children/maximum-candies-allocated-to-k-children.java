class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        long low = 1, high = 1, result = 0;
        
        for(int candie : candies) high = Math.max(candie, high);

        while(low<=high){
            long mid = (low +high)/2;
            if(possible(candies, k, mid)){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return (int) result;
    }

    private boolean possible(int[] candies, long k, long candiesToGive){
        long children = 0;

        for(int candie : candies){
            children += (candie*1l/candiesToGive);
        }

        return children >= k;
    }
}