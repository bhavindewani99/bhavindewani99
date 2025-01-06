class Solution {
    public int maxPower(String s) {
        int result = 0;
        int start = 0;
        Map<Character, Integer> set = new HashMap<>();
        int end = 0;

        while(end < s.length() ){
            char c = s.charAt(end);
            set.put(c, set.getOrDefault(c, 0) +1);

            while(set.size()>1){
                set.put(s.charAt(start), set.get(s.charAt(start)) - 1);
                if(set.get(s.charAt(start))==0) set.remove(s.charAt(start));
                start++;
            }

            result = Math.max(result, end-start+1);
            end++;
        }

        return result;
    }
}