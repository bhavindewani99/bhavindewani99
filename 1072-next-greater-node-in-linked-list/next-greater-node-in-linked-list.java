class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        Stack<int[]> stack = new Stack<>(); // stores [index, value] pairs

        ListNode curr = head;
        int index = 0;

        while (curr != null) {
            values.add(0); // initialize result value with 0 (default)

            // While stack not empty and current value is greater than stack top's value
            while (!stack.isEmpty() && curr.val > stack.peek()[1]) {
                int[] prev = stack.pop();
                values.set(prev[0], curr.val);
            }

            stack.push(new int[]{index, curr.val});
            curr = curr.next;
            index++;
        }

        // Convert result list to array
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }

        return result;
    }
}
