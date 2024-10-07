class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=2;i<=n;i++){
            s = recursion(s, '@', s.length()-1, 1, new StringBuilder());
        }
        return s;
    }

    private String recursion(String s, char last, int index, int noOftime, StringBuilder curr){
        if(index<0){
            curr.append(last);
            curr.append(noOftime);
            return curr.reverse().toString();
        }
        if(last=='@'){
            return recursion(s, s.charAt(index), index-1,1, curr);
        }else if(s.charAt(index)==last){
            return recursion(s, last, index-1, noOftime+1, curr);
        }
        curr.append(last);
        curr.append(noOftime);
        return recursion(s, s.charAt(index), index-1, 1, curr);
    }
}