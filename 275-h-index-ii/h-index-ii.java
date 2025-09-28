class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int res=0;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int hValue=n-mid;
            if(citations[mid]>=hValue){
                res=hValue;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        return res;
    }
}