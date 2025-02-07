class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int n = path.length();
        int index = 0;

        while (index < n && path.charAt(index) == '/') index++; // Skip leading slashes

        while (index < n) {
            StringBuilder curr = new StringBuilder();
            while (index < n && path.charAt(index) != '/') {
                curr.append(path.charAt(index++));
            }

            String currString = curr.toString();

            if (currString.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // Go one level up
            } else if (!currString.equals(".") && !currString.isEmpty()) {
                stack.add(currString); // Add valid directory name
            }

            while (index < n && path.charAt(index) == '/') index++; // Skip extra slashes
        }

        // Construct the result path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
