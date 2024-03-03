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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLL(l1);
        l2 = reverseLL(l2);

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode sumListHead = new ListNode(-1);
        ListNode tempNode = sumListHead;
     
        int carry = 0;
        while( node1 != null || node2 != null || carry != 0){
            int sum = 0;
            if(node1 != null){
                    sum += node1.val;
                    node1 = node1.next;
            }
            if(node2 != null){
                    sum += node2.val;
                    node2 = node2.next;
            }
            sum += carry;
            carry = sum / 10;
            
            ListNode newDigitNode = new ListNode(sum % 10);
            tempNode.next = newDigitNode;
            
            tempNode = tempNode.next;
        }
         
        return reverseLL(sumListHead.next);
        
    }

    ListNode reverseLL(ListNode head){
        if(head == null) return head;
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}