class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();

        for(String curr : allowed){
            String start = curr.substring(0,2);
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(String.valueOf(curr.charAt(2)));
        }

        return recursion(1, bottom, "", map);
    }

    private boolean recursion(int index, String bottom, String newString, Map<String, List<String>> map){
        
        String key = bottom.charAt(index-1) + "" + bottom.charAt(index);

        if(map.containsKey(key) == false) return false;
        if(bottom.length() == 2) return true;

        for(String next : map.get(key)){
            newString += next;
            boolean res = false;
            if(index+1 == bottom.length()){
                res = recursion(1, newString, "", map);
            }else{
                res = recursion(index+1, bottom, newString, map);
            }
            if(res) return true;
            newString = newString.substring(0, newString.length()-1);
        }
        return false;
    }
}