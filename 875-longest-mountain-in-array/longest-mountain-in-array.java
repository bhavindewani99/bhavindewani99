class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] previous = new int[n];
        int[] next = new int[n];

        int prev = arr[0];
        int cnt = 0;
        for(int i=1;i<n;i++){
            if(prev < arr[i]){
                cnt ++;
                previous[i] = cnt;
            }else{
                cnt = 0;
            }
            prev = arr[i];
        }

        for(int i:previous) System.out.print(i+" ");

        prev = arr[n-1];
        cnt = 0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>prev){
                cnt++;
                next[i] = cnt;
            }else cnt = 0;
            prev = arr[i];
        }

        int result = 0;

        for(int i=1;i<n-1;i++){
            if(previous[i]!=0 && next[i]!=0){
                result = Math.max(result, previous[i]+next[i] +1);
            }
        }

        return result;
    }
}