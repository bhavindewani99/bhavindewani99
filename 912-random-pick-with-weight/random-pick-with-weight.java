class Solution {
    
    int[] cumSum;
    int totalSum = 0;
    public Solution(int[] w) {
        
        cumSum = new int[w.length];
        for(int i=0;i<w.length;i++){
            totalSum += w[i];
            cumSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        int random = (int) (Math.random() * totalSum);
        int low = 0;
        int high = cumSum.length-1;
        int result = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(cumSum[mid]>random){
                high=mid-1;
                result = mid;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */