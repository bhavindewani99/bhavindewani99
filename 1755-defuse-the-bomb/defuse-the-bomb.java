class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k==0) return res;
        int left=0;
        int currSum = 0;

        for(int right=0;right<n+Math.abs(k);right++){
            currSum += code[right%n];
            
            if(right-left+1 > Math.abs(k)){
                currSum -= code[left % n];
                left = (left+1)%n;
            }

            if(right-left+1 == Math.abs(k)){
                if(k>0){
                    res[(left-1+n)%n] = currSum;
                }else{
                    res[(right+1)%n] = currSum;
                }
            }
        }
        return res;
    }
}