class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int n = price.length;
        long low = 0;
        long high = price[n-1] - price[0];
        long result = 0;

        while(low<=high){
            long mid = (low + high)/2;
            if(possible(price, k, mid, n)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return (int) result;
    }

    private boolean possible(int[] price, int k, long difference, int n){
        int elements = 1;
        int last  = price[0];

        for(int i=1;i<n;i++){
            if (price[i] - last >= difference) {
                elements++;
                last = price[i];
            }
        }
        return elements >= k;
    }
}