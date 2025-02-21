

class Solution {
    public String getHappyString(int n, int k) {
        return optimalSolutin(n, k);
    }

    private String optimalSolutin(int n, int k){
        int total = 3 * (int) Math.pow(2, n-1);
        int left = 1;
        int right = total;
        String choices = "abc";
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++){
            int curr = left;
            int partition_size = (right - left + 1) / choices.length();

            for(char c : choices.toCharArray()){
                if(curr<=k && k< curr + partition_size){
                    result.append(c);
                    choices = "abc".replace(String.valueOf(c), "");
                    left = curr;
                    right = curr + partition_size;
                    break;
                }
                curr += partition_size;
            }
        }
        return result.toString();
    }

    private String recuriveSolution(int n, int k){
        List<String> happyStrings = new ArrayList<>();
        char[] chars = {'a', 'b', 'c'};
        generateHappyStrings(new StringBuilder(), chars, n, happyStrings);
        
        if (k > happyStrings.size()) {
            return "";
        }
        return happyStrings.get(k - 1);
    }

    private void generateHappyStrings(StringBuilder current, char[] chars, int n, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current.toString());
            return;
        }

        for (char c : chars) {
            if (current.length() == 0 || current.charAt(current.length() - 1) != c) {
                current.append(c);
                generateHappyStrings(current, chars, n, happyStrings);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
