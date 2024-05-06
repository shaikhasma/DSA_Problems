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

  /*
 Approach 1 - reverse List + cut dettach smaller nodes and again revere
 1. reverse LL
 2. traverse LL
    prev = firstNode
    current = firstNode.next

    if current node is small then pre 
      move current
    if current node is greate or equal then 
      attach prev to current
      move prev & current bot

3. reverse LL
5. return head

5,2,13,3,8

8 13 15
      p    c
 TC - N + N + N
   - 0(n)
 S.C - 0(1)
   8 3 13 2 5
     c P
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
       ListNode lastNode = reverseLL(head);
       ListNode prev = lastNode;
       ListNode current = lastNode.next;

       while(current != null){
        if(prev.val <= current.val){
            prev.next = current;
            prev = prev.next;
        }

        current = current.next;
       }

       prev.next = null;
       return reverseLL(lastNode);
    }

    ListNode reverseLL(ListNode head){
      ListNode current = head;
      ListNode prev = null;

      while(current != null){
        ListNode next = current.next;
        current.next = prev ;
        prev = current;
        current = next;
      }
      return prev;
    }
}