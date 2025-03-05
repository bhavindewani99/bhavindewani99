class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int maxPower = 1;
        int curr = 1;

        while(curr*3<=n){
            maxPower++;
            curr *= 3;
        }

        while(maxPower>=0){
            int currPower = (int) Math.pow(3, maxPower);
            if(currPower <= n) n-= currPower;
            if(currPower <= n) return false;
            maxPower--;
        }
        return n==0;
    }
}