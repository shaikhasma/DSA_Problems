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
  1 1 2 3 3
        p   c 
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while(current !=  null){
            if(prev.val != current.val){
                prev.next = current;
                prev = prev.next;
            }

            current = current.next;

        }

        if(prev.next != null )
          prev.next = null;
        
     

        return head;
    }
}