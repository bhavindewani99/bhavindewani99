class Solution {
    public String stringShift(String s, int[][] shifts) {
        int netshift = 0;
        int n = s.length();

        for(int[] shift : shifts){
            if(shift[0]==0) netshift -= shift[1];
            else netshift += shift[1];
        }

        netshift = ((netshift % n) + n ) % n;
        return s.substring(n-netshift) + s.substring(0, n - netshift);
    }
}