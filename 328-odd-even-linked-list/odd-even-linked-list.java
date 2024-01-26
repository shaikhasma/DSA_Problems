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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp1 = head;
        ListNode evenListHead = head.next;

        ListNode temp2 = evenListHead;
        
        while(temp2 != null && temp2.next != null ){
            temp1.next = temp2.next;
            temp1 = temp1.next;

            temp2.next = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = evenListHead;
        return head;
    }
}