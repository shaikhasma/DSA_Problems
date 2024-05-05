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


 ////1 2 3 1 2
     //  2 1
class Solution {

    public boolean isPalindrome(ListNode head) {
     if(head == null || head.next == null)
        return true;

     ListNode middle = middleNode(head);

     ListNode left = head;
     ListNode right = reverseList(middle);

     while(right != null){
        if(left.val != right.val)
           return false;
        
        left = left.next;
        right = right.next;
     }
     
      return true;

    }

    ListNode middleNode(ListNode head){
        if(head == null || head.next == null)
           return head;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer  != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;

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