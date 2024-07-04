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
    public ListNode mergeNodes(ListNode head) {
        ListNode ansHead = new ListNode(-1);
        ListNode ansTemp = ansHead;
 
        ListNode temp = head.next;
        int sum = 0;
        while( temp != null){
           
            if(temp.val != 0)
                sum += temp.val;
            else{
              ansTemp.next = new ListNode(sum);
              ansTemp = ansTemp.next;
              sum = 0;
            }
            
            temp = temp.next;
        }

        return ansHead.next;
    }
}