class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long result = 0;
        int start = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                result += i-start;
                start++;
            }
        }

        return result;
    }
}