/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int len1 = getSize(headA);
       int len2 = getSize(headB);
       int diff = len1 - len2;

       ListNode temp1 = headA;
       ListNode temp2 = headB;
       if(diff <  0){
           temp2 = headB;
           
           while(diff != 0){
               temp2 = temp2.next;
               diff++;
           }
       }
       else if(diff > 0){
           temp1 = headA;
           
           while ( diff != 0){
              temp1 = temp1.next;
              diff--;
           }
       }

       while(temp1 != temp2){
           temp1 = temp1.next;
           temp2 = temp2.next;
       }

       return temp1;
      
    }

    int getSize(ListNode head){
        ListNode temp = head;
        int len = 0;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }

        return len;
    }

}