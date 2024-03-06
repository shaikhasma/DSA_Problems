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
 Approach 1 - recursion

 TC - 0(n)
   - 0(n)
 S.C - 0(N) auxilary space
   8 3 13 2 5
     c P
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
 
    if (head == null) return null;
            head.next = removeNodes(head.next);
            return head.next != null && head.val < head.next.val ? head.next : head;
    }   
}