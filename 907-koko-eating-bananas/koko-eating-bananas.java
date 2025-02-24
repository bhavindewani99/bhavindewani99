class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int maxBanans = Integer.MIN_VALUE;

        for(int bananas : piles) maxBanans = Math.max(maxBanans, bananas);
        int low = 1;
        int high = maxBanans;
        int result = Integer.MAX_VALUE;

        while(low<=high){
            int bananaPerHour = low + (high-low)/2;
            if(possible(piles, bananaPerHour, h)){
                result = Math.min(result, bananaPerHour);
                high = bananaPerHour - 1;
            }else{
                low = bananaPerHour + 1;
            }
        }
        return result;
    }

    private boolean possible(int[] piles, int bananaPerHour, int totalTime){
        long requiredTime = 0;
        for(int bananas : piles){
            requiredTime += bananas/bananaPerHour;
            if(bananas%bananaPerHour != 0) requiredTime++;
        }
        return requiredTime<=totalTime;
    }
}