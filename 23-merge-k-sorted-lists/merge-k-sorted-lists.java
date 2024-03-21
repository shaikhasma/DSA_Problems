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

 /* Approach - 3 Using Min Heap or Priority Queue
 TC - 0(n * k) * log k where k list total list size & n equal to  
    - 0(n * k * logk)
 SC - 0(k)
    
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((l1, l2)-> l1.val - l2.val);

       ListNode dummyHead = new ListNode(-1);
       ListNode dummyTemp = dummyHead;

        for(int index = 0; index < lists.length; index++){

            if(lists[index] != null)
                q.add(lists[index]);
        }

        if(q.isEmpty())
            return null;
        

        while(!q.isEmpty()){
            ListNode popped = q.poll();

            if(popped.next != null) 
                q.add(popped.next);

            dummyTemp.next = popped;
            dummyTemp = dummyTemp.next;
        }

        return dummyHead.next;
           
        }
        
}
