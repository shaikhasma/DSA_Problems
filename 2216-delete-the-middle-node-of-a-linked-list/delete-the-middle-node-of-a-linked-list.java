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
    public ListNode deleteMiddle(ListNode head) {
       if(head == null) return null;
       if(head.next == null){
           head = null;
           return head;
       }

       ListNode slowPointer = head;
       ListNode fastPointer = head.next.next;
       
       while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
       }
       
       slowPointer.next = slowPointer.next.next;
      return head;
        
    }
}

/*
1 3 4 7 1 2 6
    s
        p
1 2 3 4 5
  s
        p

*/