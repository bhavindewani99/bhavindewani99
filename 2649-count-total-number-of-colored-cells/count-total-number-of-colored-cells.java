class Solution {
    public long coloredCells(int n) {
       
        long result = (long) Math.pow(n, 2) + (long) Math.pow(n-1, 2);
        return result;
    }
}