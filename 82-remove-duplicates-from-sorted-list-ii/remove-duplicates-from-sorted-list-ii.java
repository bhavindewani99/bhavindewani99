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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummNode = new ListNode(-1);
        ListNode resultHead = dummNode;

        while (head!=null) {
            if(dummNode.next==null){
                dummNode.next = head;
            }else if(dummNode.next.val != head.val){
                dummNode = dummNode.next;
                dummNode.next = head;
            }else{
                while(head!=null && head.val==dummNode.next.val) head=head.next;
                dummNode.next = null;
                continue;
            }
            head=head.next;
        }
        return resultHead.next;
    }
}