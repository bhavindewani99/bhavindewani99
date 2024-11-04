class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int n = s.length();
        int[] result = new int[queries.length];
        int[] nearestLeft = new int[n];
        int[] nearestRight= new int[n];
        int[] plates = new int[n];

        // finding total plates
        if(s.charAt(0)=='*') plates[0] = 1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='*') plates[i] = plates[i-1] +1;
            else plates[i] = plates[i-1];
        }

        // finding nearestLeft candles
        int prev = -1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='|') prev = i;
            nearestLeft[i] = prev;
        }

        // finding nearestRight candles;
        prev = -1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='|') prev = i;
            nearestRight[i] = prev;
        }

        for(int i=0;i<queries.length;i++){
            int leftCandle = nearestRight[queries[i][0]];
            int rightCandle = nearestLeft[queries[i][1]];
            if(leftCandle==-1 || rightCandle==-1 || leftCandle>=rightCandle) continue;
            result[i] = plates[rightCandle] - plates[leftCandle];
        }

        return result;
    }
}