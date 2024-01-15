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
 /* Approach 1 : Add nodes value + carry approach
 1. make sume of node1 & node2 value
 2. cut digit and make new node
 3. carry = sum /10
 4. repeate step 1 2 3 till temp1 != null or temp2 != null or carry has some value
 TC - 0(n)
 SC  - 0(1)

 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode sumList = new ListNode(-1);
        ListNode tempResult = sumList;
        int carry = 0;

        while(temp1 != null || temp2 != null || carry == 1){
            int sum = 0;
            if(temp1 != null){
              sum += temp1.val;
              temp1 = temp1.next;
            }
           
           if(temp2 != null){
              sum += temp2.val;
              temp2 = temp2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            
            ListNode result = new ListNode(sum%10);
            tempResult.next = result;
            tempResult = tempResult.next;
        }

        return sumList.next;
        
    }
}