/*Approach - slow & fast pointer
- slow pointer move by one step 
- fast pointer move by two steps
once fast pointer reached at end slow would be at middle
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
 /* Approach - 1 size / 2
 1. Calculate size of LL
 2. Traverse till []size / 2 - 1]
 3. return the middle node
 TC - O(n)
 SC - O(1)
 */
 
class Solution {
    public ListNode middleNode(ListNode head) {
     if(head == null){
         return null;
     }
     int middle = getSize(head)/ 2;
     
     ListNode temp = head;
     for ( int index = 1 ; index <= middle; index++){
        temp = temp.next;
     }

     return temp;

    }
    private int getSize(ListNode head ){
       if(head == null)
          return 0;
    
       ListNode temp = head ;
       int size = 0;
       while(temp != null){
           size++;
           temp = temp.next;
       }

       return size ;
    }
}