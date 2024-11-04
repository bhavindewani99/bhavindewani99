class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }

        for(int i=1;i<words.length;i++){
            String prev = words[i-1];
            String curr = words[i];
            int l =0;
            int r = 0;
            while(l<prev.length() && r<curr.length() && prev.charAt(l)==curr.charAt(r)){
                l++;
                r++;
            }
            if(r>=curr.length() && l<prev.length()) return false;
            if(l==prev.length()) continue;
            if(map.get(prev.charAt(l)) > map.get(curr.charAt(r))) return false;
        }

        return true;
    }
}