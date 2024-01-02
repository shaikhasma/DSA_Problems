/*
Approach - slow pointer & fast pointer
1. slowPointer & fast pointer both start from dummyLL
2. gap of slowPointer & fastPointer should be n
   so, 1st traverse fastPointers for n steps 

Note: If n is equal to size then fastPointer pointer will be null
so in this case delete 1st node of linkedlist and return the new head

3. Start moving slowPointer & fastPointer by one step
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

     ListNode slowPointer = head;
     ListNode fastPointer = head;

     for(int index = 1; index <= n ; index++){
         fastPointer = fastPointer.next;
     }

     while(fastPointer != null && fastPointer.next != null){
         slowPointer = slowPointer.next;
         fastPointer = fastPointer.next;
     } 
     
     if(fastPointer == null){
        head = head.next;
        return head;
     }
       
     slowPointer.next = slowPointer.next.next;
     return head;
    }
}