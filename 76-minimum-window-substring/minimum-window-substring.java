class Solution {
    public String minWindow(String s, String t) {

        int l=0;
        int r=0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int n = s.length();
        int m = t.length();
        int cnt = m;
        int[] hash = new int[126];

        for(int i=0;i<m;i++) hash[t.charAt(i)]++;
        while(r<n){
            char c = s.charAt(r);
            if(hash[c]>0) cnt--;
            hash[c]--;
            while(cnt==0){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    startIndex=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt++;
                l++;
            }
            r++;
        }

        return startIndex==-1 ? "" : s.substring(startIndex,startIndex+minLen);
    }
}