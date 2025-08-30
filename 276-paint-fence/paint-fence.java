class Solution {
    public int numWays(int n, int k) {
        
        if(n==1) return k;
        int lastTwoSame = k;
        int lastTwoDiff = k * (k-1);
        int total = lastTwoSame + lastTwoDiff;

        for(int i=3;i<=n;i++){
            lastTwoSame = lastTwoDiff;
            lastTwoDiff = (total) * (k-1);
            total = lastTwoSame + lastTwoDiff;
        }

        return total;
    }

}


// for k = 3 (r,g,b)

// n = 2
// same = 3 (rr,gg,bb)
// diff = 6 (rg,rb, gr, gb, br, bg)


// n = 3
// same = last one's different
// diff = (same + diff) * (k-1)