/*
Approach - slow pointer & fast pointer
1. start dummyLL from given head
2. slowPointer & fast pointer both start from dummyLL
3. gap of slowPointer & fastPointer should be n
   so, 1st traverse fastPointers for n steps 
4. Start moving slowPointer & fastPointer by one step
   once fast pointer reached till end 
   slowPointer will be at nth last node we can delete that

   TC - 0(N)
   SC - 0(1)
*/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
         return null;
     ListNode dummy = new ListNode();
     dummy.next = head;

     ListNode slowPointer = dummy;
     ListNode fastPointer = dummy;

     for(int index = 1; index <= n ; index++){
         fastPointer = fastPointer.next;
     }

     while(fastPointer != null && fastPointer.next != null){
         slowPointer = slowPointer.next;
         fastPointer = fastPointer.next;
     } 
     
     slowPointer.next = slowPointer.next.next;
     return dummy.next;
    }
}