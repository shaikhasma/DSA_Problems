/*Approach - slow & fast pointer
- slow pointer move by one step 
- fast pointer move by two steps
once fast pointer reached at end slow would be at middle
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
    public ListNode middleNode(ListNode head) {
     
     if(head == null)
        return head;
        
     ListNode slowPointer = head;
     ListNode fastPointer = head;
     while(fastPointer != null && fastPointer.next != null){
         slowPointer = slowPointer.next;
         fastPointer = fastPointer.next.next;
     }
     return slowPointer;
    }
}