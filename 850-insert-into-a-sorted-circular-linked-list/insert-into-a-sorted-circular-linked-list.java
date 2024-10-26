/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head==null){
            newNode.next=newNode;
            return newNode;
        }

        Node curr = head.next;
        while(curr!=head){
            if(curr.val<=insertVal && insertVal<=curr.next.val){
                newNode.next=curr.next;
                curr.next=newNode;
                return head;
            }else if(curr.val > curr.next.val){
                if(insertVal>=curr.val || insertVal<=curr.next.val){
                    newNode.next=curr.next;
                    curr.next=newNode;
                    return head;
                }
            }
            curr=curr.next;
        }
        newNode.next = head.next;
        head.next = newNode;
        return head;
    }
}