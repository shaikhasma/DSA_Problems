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
 Approach 1- Two pointer approach
 1. traverse 
    prev stand to head
    current stand to head.next
2. if both are equal then 
    - only move current
    if both are different then
    - move prev to current
    - current move ahead by one step

3. repeate step 1 & 2 till current not null

4. if prev next is not null means prev is not last node then
   - attach prev next equal to null as current move ahead and gap is there in between pre and current 
     there are duplicates node 


TC - 0(N)
TC - 0(1)
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

        if(prev.next != null)
          prev.next = null;
        
     

        return head;
    }
}