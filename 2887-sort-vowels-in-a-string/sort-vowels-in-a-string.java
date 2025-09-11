class Solution {
    public String sortVowels(String s) {
        int[] vowels = new int[52]; 
        Set<Character> set = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z' && set.contains(c)) {
                vowels[c - 'A']++;
            } else if (c >= 'a' && c <= 'z' && set.contains(c)) {
                vowels[(c - 'a') + 26]++;
            }
        }

        int index = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                while (index < 52 && vowels[index] == 0) {
                    index++;
                }
                vowels[index]--;
                char x = index <= 25 ? (char)(index + 'A') : (char)(index - 26 + 'a');
                result.append(x);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
