class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        List<String> result = new ArrayList<>();
        char[] temp = new char[n];
        char[] options = {'0','1','6','8','9'};
        helper(0,n-1,map,result,temp,options);
        return result;
    }

    private void helper(int start, int end, Map<Character, Character> map, List<String> result, char[] temp, char[] options){
        if(start>end){
            if(temp.length==1 || temp[0]!='0') result.add(String.valueOf(temp));
            return;
        }
        for(char c : options){
            if(start==end && map.get(c)!=c) continue;
            temp[start] =c;
            temp[end] = map.get(c);
            helper(start+1, end-1, map, result, temp, options);
        }
    }
}