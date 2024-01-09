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
    public ListNode reverseList(ListNode head) {
       
     if(head == null) return null;

     ListNode prev = null;
     ListNode current = head;

     while (current != null){
         ListNode next = current.next;
         
         current.next = prev;
         prev = current;
         current = next;
         
     }

     return prev;
    }
}

/*
     1 -> 2 ->  3 ->  4 -> 5
                           p    c    n

 5 - > 4 -> 3 - > 2 -> 1 - > null


*/