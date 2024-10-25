class Solution {
    int[] w;
    int[] cumSum;
    int totalSum = 0;
    public Solution(int[] w) {
        this.w=w;
        cumSum = new int[w.length];
        for(int i=0;i<w.length;i++){
            if(i>0)
            this.cumSum[i] =this.cumSum[i-1] + w[i];
            else
            this.cumSum[i] = this.w[i];
            totalSum += this.w[i];
        }
    }
    
    public int pickIndex() {
        int random = (int) (Math.random() * totalSum);
        int low = 0;
        int high = w.length;
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