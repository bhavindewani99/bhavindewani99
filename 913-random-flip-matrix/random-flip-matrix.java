class Solution {

    int total, available, m, n;
    Map<Integer, Integer> indexToNum;
    Random random;

    public Solution(int m, int n) {
        random = new Random();
        this.m =m;
        this.n =n;
        total = m*n;
        available= total;
        indexToNum = new HashMap<>();
    }
    
    public int[] flip() {
        int randomIndex = random.nextInt(available--);
        int logicalIndex = indexToNum.getOrDefault(randomIndex, randomIndex);
        int tail = indexToNum.getOrDefault(available, available);

        indexToNum.put(randomIndex, tail);

        return new int[]{logicalIndex/n , logicalIndex%n};
    }
    
    public void reset() {
        available = total;
        indexToNum.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */