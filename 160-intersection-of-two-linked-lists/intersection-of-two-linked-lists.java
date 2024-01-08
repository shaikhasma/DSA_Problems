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
 /* Approach 1 : brute force / Naive approach 
 1. Keep of one node of list and traverse other LL 
 2. if we found match return that intersection node
    else 
      continue step 1
3. At 1st list compeleted still we did not found intersection means there is not intersection 
  return null
  TC - 0(n * M)
  SC- 0(A)
  ===> TLE
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode temp1 = headA;
       while(temp1 != null){
           ListNode temp2 = headB;
           
           while(temp2 != null){
               if(temp2 == temp1) return temp2;

               temp2 = temp2.next;
           }
           temp1 = temp1.next;
       }
       return null;
    }

}