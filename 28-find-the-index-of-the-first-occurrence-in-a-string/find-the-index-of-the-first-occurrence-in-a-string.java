class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] lps = new int[m];
        generateLPS(lps, needle, m);

        int i=0, j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
            if(j==m){
                return i - m;
            }
        }
        return -1;
    }

    private void generateLPS(int[] lps, String needle, int m){
        int prevLps =0;
        int i=1;
        while(i<m){
            if(needle.charAt(i)==needle.charAt(prevLps)){
                lps[i] = prevLps +1;
                prevLps++;
                i++;
            }else if(prevLps==0){
                i++;
            }else{
                prevLps = lps[prevLps-1];
            }
        }
    }
}