class Solution {
    public int countSubstrings(String s) {
        int result =0;
        for(int i=0;i<s.length();i++){
            result += expand(s, i, i);
            result += expand(s, i, i+1);
        }
        return result;
    }

    private int expand(String s, int left, int right){
        int ans = 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            ans++;
            left--;
            right++;
        }
        return ans;
    }
}