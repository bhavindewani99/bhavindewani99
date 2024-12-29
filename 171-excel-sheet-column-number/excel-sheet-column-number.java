class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        for(char c : columnTitle.toCharArray()){
            int val = (int)(c-'A') + 1;
            num = num*26 + val;
        }
        return num;
    }
}