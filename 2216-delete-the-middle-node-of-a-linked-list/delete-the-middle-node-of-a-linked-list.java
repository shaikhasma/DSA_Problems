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
 Approach 1. Middle + goto prev middle and then delete it

 1. find the middle node
 2. Go till previous node of middle node
 3. rereference previous of middle node to next of next node
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
       if(head == null) return head;
       if(head.next == null){
            head = null;
            return head;
       }
       
       ListNode  middleNode = getMiddleNode(head);
       ListNode temp = head;

       while(temp != null){
          if(temp.next == middleNode){
             temp.next = temp.next.next;
             return head;
          }
          
          temp = temp.next;
       }
      
      return head;
        
    }

    ListNode getMiddleNode(ListNode head){
        if(head == null) return head;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
      
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
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