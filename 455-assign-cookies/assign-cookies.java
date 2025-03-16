class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int satiesfied = 0;
        int cookiePointer = 0;

        for(int i=0;i<g.length;i++){
            while (cookiePointer<s.length && s[cookiePointer]<g[i]) {
                cookiePointer++;
            }
            if(cookiePointer==s.length) break;
            satiesfied++;
            cookiePointer++;
        }
        return satiesfied;
        
    }
}