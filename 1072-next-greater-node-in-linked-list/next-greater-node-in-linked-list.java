

import static java.lang.System.in;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode prev = null;
        int length = 0;

        while(head!=null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
            length++;
        }

        int[] result = new int[length];
        int index = length-1;
        Stack<Integer> stack = new Stack<>();

        while(prev!=null){
            while(!stack.isEmpty() && stack.peek() <= prev.val) stack.pop();

            if(stack.isEmpty()) result[index] = 0;
            else result[index] = stack.peek();
            index--;

            stack.add(prev.val);
            prev = prev.next;
        }

        return result;

    }
}