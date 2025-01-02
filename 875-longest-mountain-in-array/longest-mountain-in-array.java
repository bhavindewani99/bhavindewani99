class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n<3) return 0;

        int up =0, down =0, result = 0;

        for(int i=1;i<n;i++){

            if((down>0 && arr[i-1]<arr[i]) || (arr[i-1]==arr[i])) {
                up=0;
                down =0;
            }

            if(arr[i-1]<arr[i]) up++;

            if(arr[i-1]>arr[i]) down++;

            if(up>0 && down>0){
                result = Math.max(result, up+down+1);
            }
        }

        return result;
    }
}