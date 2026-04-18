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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = new ListNode(-1);
        temp.next = head;
        int sum = 0;
        map.put(sum, temp);

        while(head != null){
            sum += head.val;
            if(map.containsKey(sum)){
                ListNode remove = map.get(sum).next;
                int tempSum = sum;

                while(remove != head){
                    tempSum += remove.val;
                    map.remove(tempSum);
                    remove = remove.next;
                }
                map.get(sum).next = head.next;
            }
            else{
                map.put(sum, head); 
            }
            head = head.next;
        }

        return temp.next;
    }

    
}