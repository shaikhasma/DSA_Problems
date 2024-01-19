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
 /* Approach - Using Two pointer reach till k - 1 th node &  attach the reverse to head
 1. start both pointers from head
 2. move 2nd pointer k times
 3. now move both pointer one by one till 2nd pointer reaches
    last node
    -- Here 1st pointer reached at k - 1th node
 4.  take there reference of remaining list from k to end into 
     l1
    --- list = p1.next
5.  point p1 next to null as we have to cut the list
5. traverse l1 till end using temp pointer
   -- once temp is at last node attach head to the next of temp

1-- > 2 --> 3.     4---> 5.---> 1-- > 2 --> 3.   k = 2
           p1      l1.  temp.   head
                        p2

 TC : 0(n) + 0(n)    + 0(n-k)
      size  k-1th
      = 0(n)
SC - 0(1)

 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) 
          return head;
        int size = getSize(head);
        while(size < k ) k = k - size; 

         if(k == 0 || getSize(head) == k)  return head ;
        
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        
        for(int count = 1; count <= k; count++){
           secondPointer = secondPointer.next;
        }

        while(secondPointer.next != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        ListNode l1 = firstPointer.next;
        firstPointer.next = null;

        ListNode temp = l1;
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head = l1;
        return head;
    
    }
    int getSize(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}