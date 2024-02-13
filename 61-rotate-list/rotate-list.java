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
 /* Approach 3 - Convert into circular LL
 1. Traverse LL and calculate length
 2. if k == length return head as it is
 3. if k > length k = k % len;
    
 4. find breakPoint len - k need to traverse breakPoint - 1 
    -- create breakPoint - 1 next element as head
    -- break the link
    
5.  Return the new head

1-- > 2 --> 3 ---> 4---> 5  k = 7
           
len = 5
7>5
k = 7 % 5 
k = 2
if k == len return head
convert it into circular
1--- > 2 ---> 3 --->4---> 5 ---> 1 ---> 2......
breakPoint = 5 - 2
traverse breakPoint

1.    2.    3   h
1-- > 2 --> 3   4---> 5---> 1--- > 2 ---> 3  
                      

 TC : 0(n) + 0(n)
      size    traverse till breakpoint
      = 0(n)
SC - 0(1)

 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) 
          return head;
       
       int len = 0;
       ListNode temp = head;
       while(temp.next != null){
           len++;
           temp = temp.next;
       }
       //convert linear to circutlar if k not equal to length
        if( k == len + 1) 
           return head;

       //calculate last node in length and pointing last node to head    
       temp.next = head;
       len++;

        if(k > len)
           k = k % len;
          
        // identify breaking point
        int breakLinkPoint = len - k;
        temp = head;
        for(int index = 1; index < breakLinkPoint; index++ ){
            temp = temp.next;
        }
        
        head = temp.next;
        temp.next = null;

        return head;
    
    }
    
}