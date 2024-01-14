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
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode sumList = new ListNode(-1);
        ListNode tempResult = sumList;
        int carry = 0;

        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carry;
            carry = sum /10 ;
            
            ListNode result = new ListNode(sum%10);
            tempResult.next = result;
            tempResult = tempResult.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null){
            int sum = temp1.val + carry;
            carry = sum /10;
            ListNode result = new ListNode(sum%10);
            tempResult.next = result;
            tempResult = tempResult.next;
            temp1 = temp1.next ;
        
        }

         while(temp2 != null){
            int sum = temp2.val + carry;
            carry = sum /10;
            ListNode result = new ListNode(sum%10);
            tempResult.next = result;
            tempResult = tempResult.next;
            temp2 = temp2.next;
        }
        
        while(carry != 0){
            ListNode result = new ListNode(carry%10);
            carry = carry / 10;
            tempResult.next = result;
            tempResult = tempResult.next;

        }

        return sumList.next;
        
    }
}