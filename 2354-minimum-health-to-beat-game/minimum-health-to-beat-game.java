class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int maxi = 0;

        for(int currDamage : damage){
            maxi = Math.max(maxi, currDamage);
            sum+=currDamage;
        }
        maxi = Math.min(maxi, armor);
        return sum - maxi + 1;
        
    }
}