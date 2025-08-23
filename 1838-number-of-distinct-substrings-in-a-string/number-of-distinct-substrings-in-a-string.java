class Solution {
    public int countDistinct(String s) {
        Set<String> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            String curr = "";
            for(int j=i;j<s.length();j++){
                curr += s.charAt(j);
                set.add(curr);
            }
        }
        return set.size();
    }
}