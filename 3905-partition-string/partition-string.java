class Solution {
    public List<String> partitionString(String s) {
        
        Set<String> seen = new HashSet<>();
        String curr = "";
        List<String> result = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            curr += s.charAt(i);

            if(!seen.contains(curr)){
                result.add(curr);
                seen.add(curr);
                curr = "";
            }
        }

        return result;
    }
}