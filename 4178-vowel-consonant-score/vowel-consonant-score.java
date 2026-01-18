class Solution {
    public int vowelConsonantScore(String s) {
        
       Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
       int v = 0, c = 0;

       for(char curr : s.toCharArray()){
            if(set.contains(curr)) v++;
            else if(curr >= 'a' && curr <= 'z') c++;
       }

       if(c == 0) return 0;
       return (int) Math.floor(v/c);
 
    }
}