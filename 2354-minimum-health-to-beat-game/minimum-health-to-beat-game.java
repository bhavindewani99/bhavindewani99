class Solution {
    public long minimumHealth(int[] damage, int armor) {
        // we will try to give armor to the element which is taking maximum health
        // then we subtract the health we provided using the armor from the total
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