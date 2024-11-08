class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size()>k){
                char startChar = s.charAt(start);
                if(map.get(startChar)==1) map.remove(startChar);
                else  map.put(startChar, map.get(startChar)-1);
                start++;
            }
            result = Math.max(result, i-start+1);
        }
        return result;
    }
}