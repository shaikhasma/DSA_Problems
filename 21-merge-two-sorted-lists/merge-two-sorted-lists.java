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
 /*Approach 1 - Using two Pointers
 1. create two pointer points to head of list 1 & list2
 2. Take dummyHead with -1 value
 3. check which pointer value is small 
   - point dummyHead to small value node & move that small value pointer ahead
   do the same if other node valu is small
4. If any one of list is finished point other list as it is & vice versa

 TC - 0(N)
 SC - 0(1)

 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTemp = dummyHead;

        while(temp1 != null && temp2 != null){
            if(temp2.val < temp1.val ){
                dummyTemp.next = temp2;
                temp2 = temp2.next;
            }
            else{
                dummyTemp.next = temp1;
                temp1 = temp1.next;
            }
            dummyTemp = dummyTemp.next;
        }

        if(temp1 == null){
           dummyTemp.next = temp2;
        }

        if(temp2 == null){
            dummyTemp.next = temp1;
        }

        return dummyHead.next;
    }
    
}