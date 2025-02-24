class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Long> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0l) + 1);
        }

        Map<Character, Long> countS = new HashMap<>();
        int have = 0;
        int need = countT.size();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            countS.put(c, countS.getOrDefault(c, 0l) + 1);

            if (countT.containsKey(c) && Long.compare(countS.get(c), countT.get(c)) == 0) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                countS.put(leftChar, countS.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && Long.compare(countS.get(leftChar), countT.get(leftChar))<0) {
                    have--;
                }
                left++;
            }
        }

        return result;
    }
}
