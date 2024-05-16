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

 /* Approach - 2  Merge  linked lists
 TC - 
    - 
 SC - 
    
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
      
      
        ListNode mergedListHead = null;
        for(int index = 0; index < lists.length; index++){
         
             mergedListHead = mergeSort(mergedListHead, lists[index]);
        }

        return mergedListHead;
        
    }
    ListNode mergeSort(ListNode l1, ListNode l2){
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      ListNode temp1 = l1;
      ListNode temp2 = l2;
      ListNode dummyHead = new ListNode(-1);
      ListNode dummyTemp = dummyHead;

      while(temp1 != null && temp2 != null){
           if(temp1.val < temp2. val){
               dummyTemp.next = temp1;
               temp1 = temp1.next;
           }else{
               dummyTemp.next = temp2;
               temp2 = temp2.next;
           }
           dummyTemp = dummyTemp.next;
      }

      if(temp1 != null)
         dummyTemp.next = temp1;
      else
         dummyTemp.next = temp2;

      return dummyHead.next;
    }
        
}