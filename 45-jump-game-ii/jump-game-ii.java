class Solution {
    public int jump(int[] nums) {

        

        int n = nums.length;
        if(n==1) return 0;
        int end = 0;
        int farthest=0;
        int jumps=0;
        for(int i=0;i<n;i++){
            farthest = Math.max(farthest,i+nums[i]);
            if(i==end){
                jumps++;
                end= farthest;
                if(end>=n-1) return jumps;
            }
        }
        return jumps;
    }
}