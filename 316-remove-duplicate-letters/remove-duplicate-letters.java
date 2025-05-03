class Solution {
    public String removeDuplicateLetters(String s) {
        // Step 1: Record the last index of each character in the string
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> inStack = new HashSet<>();

        // Step 2: Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If character is already in the stack, skip it
            if (inStack.contains(currentChar)) continue;

            // Step 3: Remove characters from the stack if:
            // - The current character is smaller (for lexicographic order)
            // - The top of the stack appears again later in the string
            while (!stack.isEmpty() &&
                   currentChar < stack.peek() &&
                   lastIndex.get(stack.peek()) > i) {
                inStack.remove(stack.pop());
            }

            // Add current character to the stack and mark it as seen
            stack.push(currentChar);
            inStack.add(currentChar);
        }

        // Step 4: Build the final result from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
