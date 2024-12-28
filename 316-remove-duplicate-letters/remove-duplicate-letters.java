class Solution {
    public String removeDuplicateLetters(String s) {
        // Map to store the last occurrence of each character
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPos.put(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!seen.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && lastPos.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                stack.push(c);
                seen.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

}
