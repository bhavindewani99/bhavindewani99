class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> set = new HashSet(Arrays.asList('a','e','i','o','u'));
        //int vowelCount =0;

        for(char c : s.toCharArray()){
            if(set.contains(c)) return true;
        }

        return false;
    }
}


// even -> alice remove odds and win as odd will remain
// odd -> alice win