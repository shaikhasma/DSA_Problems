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

 TC - N + N + N
   - 0(n)
 S.C - 0(1)
   8 3 13 2 5
     c P
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
 

        ListNode lastNode = reverseLL(head);
        ListNode currentNode = lastNode.next;
        ListNode prevNode = lastNode;

        while(currentNode != null){
            if(prevNode.val <= currentNode.val){
             prevNode.next = currentNode;
             prevNode = prevNode.next;
            }
            currentNode = currentNode.next;
        }
        prevNode.next = currentNode;
        
    

        return reverseLL(lastNode);
    }

    ListNode reverseLL(ListNode head){
       if(head == null)  return head;

       ListNode current = head;
       ListNode prev = null;

       while(current != null){
           ListNode next = current.next;
           current.next = prev;

           prev = current;
           current = next;
       }

       return prev;
    }
}