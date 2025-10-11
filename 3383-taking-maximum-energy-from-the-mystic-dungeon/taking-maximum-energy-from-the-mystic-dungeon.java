class Solution {
    public int maximumEnergy(int[] energy, int k) {
        
        int n = energy.length;
        int[] dp = new int[n];
        int maxEne = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int prevEnergy = i-k>=0 ? dp[i-k] : 0;
            int currEnergy = Math.max(energy[i], energy[i]+prevEnergy);
            dp[i] = currEnergy;
            //maxEne = Math.max(maxEne,energy[i]);
            if(i+k>=n) maxEne = Math.max(maxEne,dp[i]);

        }
        return maxEne;
    }
    
}