class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        long low = 0, high = (int) 1e9;
        long radius = Integer.MAX_VALUE;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        while (low<=high) {
            long mid = low +(high-low)/2;
            if(possible(mid, houses, heaters)){
                radius = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return (int) radius;
    }

    private boolean possible(long minRadius, int[] houses, int[] heaters){
        int housesIndex = 0, heatersIndex = 0;

        while(housesIndex < houses.length && heatersIndex < heaters.length){
            if(houses[housesIndex] <= heaters[heatersIndex]){
                if(((long) houses[housesIndex] + minRadius) < (long) heaters[heatersIndex]) return false;
                housesIndex++;
            }else{
                if(((long) houses[housesIndex] - minRadius) <= (long) heaters[heatersIndex]) {
                    housesIndex++;
                }else{
                    heatersIndex++;
                }
            }
        }
        return housesIndex == houses.length;
    }

}