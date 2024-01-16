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
 /* Approach - length , Using two pointer approach reverse k nodes 
 1. calcualte length
 2. count = 0 
 3. start reversing the node using two pointer approach 
    while reversing nodes increment count 
    once count is k-1 then stop
4. l = l - k substract the node which we already reversed
5. if remaining node and still more than k repeate the steps 2 , 3  & 4
6. if not attach the remaining node as it is
7. return the head

 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
     int size = getSize(head);
     return revList(head, k , size);
    }

    ListNode revList(ListNode head, int k, int size){
        if(head == null ) return null;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        int count = 0;

        while(current != null && count < k && size >= k ){
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
          count++;
        }
        
        size = size - k;
        if(size > 0 && size < k){
           head.next = next;
        }else{
           head.next = revList(next, k, size);
        }
       return prev;
    }
    int getSize(ListNode head){
       
           int size = 0;
           ListNode temp = head;
           while(temp != null){
                 size++;
               temp = temp.next;   
           }
           return size;
    }
   
}