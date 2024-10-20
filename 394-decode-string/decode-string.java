class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ']') {
                stack.add(String.valueOf(c));
            } else {
                StringBuilder curr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    curr.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder times = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    times.insert(0, stack.pop());
                }

                int repeatCount = Integer.parseInt(times.toString());
                String repeatedStr = curr.toString().repeat(repeatCount);
                
                // Push the repeated string back into the stack
                stack.add(repeatedStr);
            }
        }

        // Build the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
