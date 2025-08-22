class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for(String curr : dictionary){
            if(curr.length() >= result.length()){
                if(check(s, curr) && (curr.length()>result.length() || result.compareTo(curr) > 0)) result = curr;
            }
        }

        return result;
    }

    private boolean check(String s, String match){
        int i=0,j=0;

        while (i<s.length() && j<match.length()) {
            if(s.charAt(i)==match.charAt(j)) j++;
            i++;
        }
        return j==match.length();
    }
}