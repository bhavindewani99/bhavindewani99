/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int res = -1;
        
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(isBadVersion(mid)==true){
                res = mid;
                high = mid-1;
            }else if(isBadVersion(low)==true){
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
}