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