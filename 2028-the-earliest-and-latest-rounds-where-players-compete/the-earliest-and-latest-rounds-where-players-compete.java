class Solution {

    int early = Integer.MAX_VALUE, last = Integer.MIN_VALUE, n;

    public int[] earliestAndLatest(int n, int p1, int p2) {
        this.n = n;
        int mask = (1 << n) - 1; // all players active
        p1 -= 1;  // convert to 0-based
        p2 -= 1;
        dfs(0, n - 1, p1, p2, 1, mask);
        return new int[]{early, last};
    }

    private void dfs(int left, int right, int p1, int p2, int round, int mask) {
        // if only one player remains, stop
        if (Integer.bitCount(mask) == 1) return;

        // reached end of current round, go to next
        if (left >= right) {
            dfs(0, n - 1, p1, p2, round + 1, mask);
            return;
        }

        // skip inactive players
        if ((mask & (1 << left)) == 0) {
            dfs(left + 1, right, p1, p2, round, mask);
            return;
        }
        if ((mask & (1 << right)) == 0) {
            dfs(left, right - 1, p1, p2, round, mask);
            return;
        }

        // found the round where p1 meets p2
        if ((left == p1 && right == p2) ) {
            early = Math.min(early, round);
            last = Math.max(last, round);
            return;
        }

        // both players active, explore both outcomes
        if (left != p1 && left != p2) {
            int newMask = mask & ~(1 << left); // left loses
            dfs(left + 1, right - 1, p1, p2, round, newMask);
        }
        if (right != p1 && right != p2) {
            int newMask = mask & ~(1 << right); // right loses
            dfs(left + 1, right - 1, p1, p2, round, newMask);
        }
    }
}
