class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> countS = new HashMap<>();
        int have = 0;
        int need = countT.size();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            countS.put(c, countS.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && countS.get(c).intValue() == countT.get(c).intValue()) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                countS.put(leftChar, countS.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && countS.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return result;
    }
}
