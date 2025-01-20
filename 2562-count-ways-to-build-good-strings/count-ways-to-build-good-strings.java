class Solution {
    int modulo = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        
        Integer[] memo = new Integer[high + 1];
        return dfs(0, low, high, zero, one, memo);
    }

    private int dfs(int currLength, int low, int high, int zero, int one, Integer[] memo) {
        
        if (currLength > high) return 0;

        if (memo[currLength] != null) return memo[currLength];

        int count = 0;

        if (currLength >= low) count = 1;

        count = (count + dfs(currLength + zero, low, high, zero, one, memo)) % modulo;
        count = (count + dfs(currLength + one, low, high, zero, one, memo)) % modulo;

        
        memo[currLength] = count;
        return count;
    }
}
