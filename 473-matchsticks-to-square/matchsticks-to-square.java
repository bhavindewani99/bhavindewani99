class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int n = matchsticks.length;
        boolean[] used = new boolean[n];
        int sum = 0;

        for(int x: matchsticks) sum += x;
        if(sum % 4 != 0) return false;

        return backtrack(n, matchsticks, used, 0, sum/4, 0, 0);

    }


    private boolean backtrack(int n, int[] matchsticks, boolean[] used, int sides, int target, int currsum, int index) {
    if (sides == 3) return true; // Optimization: 3 sides found = 4th side is guaranteed
    
    if (currsum == target) {
        // Start fresh from index 0 to find the NEXT side
        return backtrack(n, matchsticks, used, sides + 1, target, 0, 0);
    }

    for (int i = index; i < n; i++) {
        if (!used[i] && currsum + matchsticks[i] <= target) {
            used[i] = true;
            // Pass the updated sum into the call; if it returns false, 
            // used[i] = false handles the backtrack perfectly.
            if (backtrack(n, matchsticks, used, sides, target, currsum + matchsticks[i], i + 1)) {
                return true;
            }
            used[i] = false;
        }
    }
    return false;
}

}