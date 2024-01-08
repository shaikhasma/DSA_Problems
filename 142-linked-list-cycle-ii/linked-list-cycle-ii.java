/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null) 
        return null;
        
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    ListNode entryPointer = head;

    while(fastPointer != null && fastPointer.next != null){
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;

        if(slowPointer == fastPointer){
           
            while(entryPointer != slowPointer){
                slowPointer = slowPointer.next;
                entryPointer = entryPointer.next;
            }

            return entryPointer;
        }

    }
    return null;

    }
}