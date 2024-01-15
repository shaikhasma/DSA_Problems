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
    int size(ListNode head) {
    int length = 0;
    while(head != null) {
        length++;
        head = head.next;
    }
    return length;
}
    public ListNode reverseKGroup(ListNode head, int k) {
       int l = size(head);
        return reverseLL(head, k, l);
    }
    public ListNode reverseLL(ListNode head, int k, int l) {
     if( head == null)
            return null;
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        int count = 0;
        
        while(current != null && count < k && l >= k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        l = l - k;
        if(l > 0 && l < k )
            head.next = next;
        else
        head.next = reverseLL(next, k, l);
        
        return prev;
    }
}