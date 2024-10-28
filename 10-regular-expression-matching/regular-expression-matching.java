class Solution {
    public boolean isMatch(String s, String p) {
        Map<String,Boolean> map = new HashMap<>();
        return recursion(s, 0, p, 0, map);
    }


    private boolean recursion(String s, int i, String p, int j,Map<String,Boolean> map){
        if(i==s.length() && j>=p.length()) return true;
        if(j>=p.length()) return false;

        String key = i + "#" + j;
        if(map.containsKey(key)) return map.get(key);

        boolean match = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));
        if(j+1 < p.length() && p.charAt(j+1)=='*'){
            boolean res = recursion(s, i, p, j+2,map) || (match && recursion(s, i+1, p, j,map));
            map.put(key, res);
            return res;
        }
        if(match){
            boolean res = recursion(s, i+1, p, j+1,map);
            map.put(key, res);
            return res;
        }
        map.put(key, false);
        return false;
    }
}