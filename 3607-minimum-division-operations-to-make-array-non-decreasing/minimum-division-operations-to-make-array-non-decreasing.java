class Solution {
    public int minOperations(int[] nums) {
        int result = 0;
        int n = nums.length;
        int last = nums[n-1];

        for(int i=n-2;i>=0;i--){
            if(nums[i]<=last) {
                last = nums[i];
            }
            else{
                int num = nums[i];
                int divisble =  getNextPossible(num, last);
                System.out.print(divisble+" ");
                if(divisble==-1) return -1;
                
                result++;
                last = divisble;
            }
        }
        return result;
    }

    private int getNextPossible(int num, int last){
        for(int K =2;K<=last;K++){
            if(num%K==0) return K;
        }
        return -1;
    }
}