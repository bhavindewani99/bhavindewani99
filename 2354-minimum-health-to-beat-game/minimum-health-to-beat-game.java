class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int used = 0;

        for(int currDamage : damage){
            used = Math.max(used, currDamage);
            sum+=currDamage;
        }
        used = Math.min(used, armor);
        return sum - used + 1;
        
    }
}