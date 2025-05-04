class Solution {
    public int hIndex(int[] citations) {
        
        int low = 0, high = citations.length, result = 0;

        while(low<=high){
            int mid = (low + high)/2;
            if(possible(mid, citations)){
                result = mid;
                low = mid+1;
            }else{
                high = mid -1;
            }
        }

        return result;
    }

    private boolean possible(int mid, int[] citations){
        int curr = 0;

        for(int citation : citations){
            if(citation >= mid) curr++;
        }

        return curr >= mid;
    }
}