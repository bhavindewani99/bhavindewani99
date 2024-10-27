class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        int l = 0;
        int r = num.length()-1;
        while(l<=r){
            char start = num.charAt(l);
            char end = num.charAt(r);
            if(!map.containsKey(start) || map.get(start)!=end) return false;
            l++;
            r--;
        }
        return true;
    }
}