class Solution {
    public String getHappyString(int n, int k) {
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
