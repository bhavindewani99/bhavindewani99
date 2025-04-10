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

    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    public int getRandom() {
        ListNode curr = head;
        int result = -1;

        for(int i=1; curr!=null; i++){
            if(random.nextInt(i)==i-1){
                result = curr.val;
            }
            curr = curr.next;
        }

        return result;
    }
}

// We are doing reservoir sampling it generated sequence of 1 * 1/2 * 2/3 * 3/4 ......
// Suppose we only had one value then random will return 0 and result will have the answer
// Suppose we have 2 values then when i==2 random can return 0 or 1 so if it return 1 then we update the result
// Suppose we had 3 values random can return 0, 1, 2 if return 2 then we update answer else keep same as previous