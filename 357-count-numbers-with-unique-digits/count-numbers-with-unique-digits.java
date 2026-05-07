class Solution {

    int res = 1;
    public int countNumbersWithUniqueDigits(int n) {

        if(n==0) return res;
        
        backtrack(n, 0, 0, new boolean[10]);

        return res;
    }

    private void backtrack(int n, int digits, int curr, boolean[] used){
        if(digits == n) return;

        for(int i=0;i<10;i++){
            if(i==0 && curr == 0) continue;
            if(!used[i]){
                res++;
                used[i] = true;
                backtrack(n, digits+1, curr*10 + i,used);
                used[i] = false;
            }
        }
    }
}