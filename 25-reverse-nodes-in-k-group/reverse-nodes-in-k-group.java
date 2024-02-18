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
 /* Approach - 1 
 1. calculate length 
 2. count = 0
 3. reverse nodes one by one using two pointer approach
    count++ everytime
    if count is equal to k - 1 stop reversing nodes
    here we reverse first k groups
4.  l = l - k
    count = 0
    if( l >=0 && l <=k)
     repeate step 3, 4
5. return prev

 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      int l = length(head);
      return reverseLL(head, k, l);
    }
    ListNode reverseLL(ListNode head, int k, int l){
        if(head == null)
         return head;

      int count = 0;
      ListNode current = head;
      ListNode prev = null;
       ListNode next = null;

      while(current != null && count < k && l >= k ){
           next = current.next;
          current.next = prev;
          prev = current;
          current = next;
          count++;
      }

      l = l - k;

      if(l > 0 && l < k)
        head.next = next;
      else
       head.next = reverseLL(next, k , l);

      return prev;
    }
   int length(ListNode head){
       if(head == null)
        return 0;
       int size = 0;
       ListNode temp = head;
       while(temp != null){
           size++;
           temp = temp.next;
       }
       return size;
   }
}