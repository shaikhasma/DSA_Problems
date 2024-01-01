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
    public ListNode reverseList(ListNode head) {
       
       return reverseList(head, null);
    }

    public ListNode reverseList(ListNode current, ListNode prev){
        if(current == null)
            return prev;
        
        ListNode next = current.next;
        current.next = prev;
        return reverseList(next,current);
        
    }
}

/*
     1 -> 2 ->  3 ->  4 -> 5
                           p    c    n

 5 - > 4 -> 3 - > 2 -> 1 - > null


*/