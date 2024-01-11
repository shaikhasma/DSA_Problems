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
 /* Approach. 2 - Middle of LL + reverse 2n half & Two Pointer approach
 1. Find the middle 
 2. Reverse 2nd half of LL
 2. Using two pointer check array is palindrom or not

 TC - o(n) + 0(n/2) = 0(n)
 SC = 0(1)
 */

class Solution {

    public boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null)
        return true;

      ListNode middle = getMiddle(head);
      ListNode right = reverseLL(middle.next);
      ListNode left = head;

      while(right != null){
          if(left.val != right.val)
            return false;

          left = left.next;
          right = right.next;
      }

      return true;
      
    }

    ListNode reverseLL(ListNode head){
        if(head == null)
            return head;
        
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    ListNode getMiddle(ListNode head){
        if(head == null || head.next == null)
          return null;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}