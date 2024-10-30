class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = -1;
        int[] res = new int[n];

        for(int i=0;i<n;i++){
            if(nums[i]<0) l=i;
        }

        if(l==-1) {
            for(int i=0;i<n;i++){
                res[i] = nums[i]*nums[i];
            }
            return res;
        }

        int r = l+1;
        int index=0;
        System.out.print("l = "+l +" r = "+r);
        while(l>=0 && r<n){
            if(Math.abs(nums[l])<=nums[r]){
                res[index++] = nums[l]*nums[l];
                l--;
            }else{
                res[index++] = nums[r]*nums[r];
                r++;
            }
        }
        while(l>=0){
            res[index++] = nums[l]*nums[l];
            l--;
        }
        while(r<n){
            res[index++] = nums[r]*nums[r];
            r++;
        }
        return res;

    }
}