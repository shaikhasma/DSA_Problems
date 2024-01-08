/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /* Approach 1 : Using hasing
 1. Traverse LL and put node into set
 2. while putting into set if we already found then return true as there is cycle
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp)) return true;
            
            set.add(temp);
            temp = temp.next;
        }
     
      return false;
    }
}