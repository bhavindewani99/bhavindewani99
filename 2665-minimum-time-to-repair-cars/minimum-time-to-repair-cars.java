class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        long low = 1, high = 1, result = -1;

        for(int rank : ranks) high = Math.max(high, rank);

        high = high * cars * cars;

        while(low<=high){
            long mid = (low+high)/2;
            if(possible(ranks, mid, cars)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean possible(int[] ranks, long time, int totalCars){
        long canDo = 0;

        for(int rank : ranks){
            canDo += (long) Math.sqrt((time/rank));
        }
        return canDo >= totalCars;
    }
}