class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(k<arr[0]) return k;
        k-= arr[0]-1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-1==arr[i-1]) continue;
            int diff = arr[i]-arr[i-1]-1;
            if(diff>=k){
                return arr[i-1] +k;
            }
            k-=diff;
        } 
        return arr[arr.length-1]+k;
    }
}