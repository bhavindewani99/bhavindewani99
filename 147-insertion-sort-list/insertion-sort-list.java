class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0); // Dummy node before head
        dummy.next = head;
        ListNode prev = head; // Last node in sorted portion
        ListNode curr = head.next; // Current node to insert

        while (curr != null) {
            if (curr.val >= prev.val) {
                // Already in correct position
                prev = curr;
                curr = curr.next;
            } else {
                // Remove curr from list
                prev.next = curr.next;

                // Find insertion spot starting from dummy
                ListNode temp = dummy;
                while (temp.next.val < curr.val) {
                    temp = temp.next;
                }

                // Insert curr in the found spot
                curr.next = temp.next;
                temp.next = curr;

                // Move curr forward
                curr = prev.next;
            }
        }

        return dummy.next;
    }
}
