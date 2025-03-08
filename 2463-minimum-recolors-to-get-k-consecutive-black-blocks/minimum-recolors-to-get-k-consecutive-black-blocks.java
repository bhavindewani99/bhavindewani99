class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int white = 0;
        int result = Integer.MAX_VALUE;

        for(int i=0;i<blocks.length();i++){
            if(blocks.charAt(i)=='W') white++;
            if(i>=k && blocks.charAt(i-k)=='W') white--;
            if(i>=k-1) result= Math.min(result, white);
        }
        return result;
    }
}