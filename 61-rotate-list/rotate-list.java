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
    public ListNode rotateRight(ListNode head, int k) {
       if(head == null || head.next == null)
            return head;
       int size = getLLSize(head);
      
       if(k > size)
           k = k % size;
       if(size == k  || k == 0)
           return head;

       ListNode first = head;
       ListNode second = head;
     
       for(int count = 1; count <= k; count++){
         second = second.next;
       }
       //second move to till last 
       while(second != null && second.next != null){
        first = first.next;
        second = second.next;
       }
       //first at k - 1 th 
       ListNode newHead = first.next;
       first.next = null;

       second.next = head;
       head = newHead;

       return head;
       
    }

    int getLLSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }

        return count;

    }
}