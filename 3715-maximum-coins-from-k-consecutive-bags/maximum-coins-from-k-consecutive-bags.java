class Solution {
    public long maximumCoins(int[][] arr, int k) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        long amount = 0;
        int n = arr.length;
        long currAmount = 0;

        for(int i=0,j=0; i<n; i++){
            while(j<n && arr[j][1]<=arr[i][0]+k-1){
                currAmount += (long)(arr[j][1]-arr[j][0]+1)*(long)arr[j][2];
                j++;
            }
            long partial = 0;
            if(j<n){
                int endPart = arr[i][0]+k-1;
                if(endPart>=arr[j][0]){
                    partial = (long)(endPart-arr[j][0]+1)*(long)arr[j][2];
                }
            }
            amount = Math.max(amount,currAmount+partial);
            currAmount -= (long)(arr[i][1]-arr[i][0]+1)*(long)arr[i][2];
        }

        currAmount = 0;

        for(int j=n-1,i=n-1; j>=0; j--){
            while(i>=0 && arr[i][0]>=arr[j][1]-k+1){
                currAmount += (long)(arr[i][1]-arr[i][0]+1)*(long)arr[i][2];
                
                i--;
            }

            long partial = 0;

            if(i>=0){
                int endPart = arr[j][1]-k+1;
                if(endPart<=arr[i][1]){
                    partial = (long)(arr[i][1]-endPart+1)*(long)arr[i][2];
                }
            }
            
            amount = Math.max(amount,currAmount+partial);   
            currAmount -= (long)(arr[j][1]-arr[j][0]+1)*(long)arr[j][2];
        }
        return amount;
    }
}