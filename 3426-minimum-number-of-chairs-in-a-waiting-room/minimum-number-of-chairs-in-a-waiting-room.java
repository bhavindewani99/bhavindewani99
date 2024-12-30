class Solution {
    public int minimumChairs(String s) {
        int chair = 0;
        int result = 0;
        for(char c : s.toCharArray()){
            if(c=='E') chair++;
            else chair --;
            result = Math.max(result, chair);
        }

        return result;
    }
}