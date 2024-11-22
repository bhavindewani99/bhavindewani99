class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;

        // Find the node just before 'a'
        for (int i = 0; curr != null && i < a - 1; i++) {
            curr = curr.next;
        }
        ListNode start = curr;

        // Find the node just after 'b'
        ListNode end = start;
        for (int i = 0; end != null && i < b - a + 2; i++) {
            end = end.next;
        }

        // Connect the node before 'a' to the start of list2
        start.next = list2;

        // Find the end of list2
        while (start.next != null) {
            start = start.next;
        }

        // Connect the end of list2 to the node after 'b'
        start.next = end;

        return list1;
    }
}
