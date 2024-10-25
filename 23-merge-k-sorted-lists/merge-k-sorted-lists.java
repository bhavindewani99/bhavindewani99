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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) ->a.val - b.val);
        for(int i=0;i<lists.length;i++) {
            if(lists[i]!=null)
            pq.offer(lists[i]);
        }
        

        while(!pq.isEmpty()){
            ListNode currNode = pq.poll();
            head.next = currNode;
            head=head.next;
            if(currNode.next!=null) pq.offer(currNode.next);
        }
        return node.next;
    }
}