/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null)
         return;
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}


/*
10. -- > 20 --> 30 --> 40 --> N
delete30       Node.   node.next.val = 40

10 ---> 20---> 40 --> -> N
               node.next = node.next.next

*/               