/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node end = null;
    public Node flatten(Node head) {
      if(head == null) return end;
		// 0. head -> flatten(head.child) -> flatten(head.next) -> end 
		// 1. flatten(head.next) -> end 
        end = flatten(head.next);
		// 2. head -> flatten(head.child) 
        head.next = flatten(head.child);
		// 3. flatten(head.child) -> flatten(head.next)
        if(head.next != null) 
            head.next.prev = head;

        head.child = null;
        return head;  
    }
}