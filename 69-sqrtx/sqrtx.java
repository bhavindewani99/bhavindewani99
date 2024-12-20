class Solution {
    public int mySqrt(int x) {
        int low =0;
        int high = x;
        int res = 0;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            long pow = (long)mid*mid;
            if(pow<=x){
                res = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
    }
}