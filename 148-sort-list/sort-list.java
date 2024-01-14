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
 /*
 Approach - 1 Merge sort
 1. find the middle of LL
  Note ** ( slightly change middle should return previous of middle element as we need to cut list from there it self)
 2. do the same step one for left linked list & right linked list
 3. once only one single element or null left stop step 1 & 2
 4. Finally merge left list & right list and return back
 TC = 0(logN)    *   0(n).   + 0(N/2)
       recursion.   mergeLL.   find middle
    = 0(logN * n + n/2)
    = 0(nlogn)

 SC = 0(log N) recursion stack space

 */
class Solution {
    public ListNode sortList(ListNode head) {
     if(head == null || head.next == null) 
        return head;

     //Step 1 : find the middle 
     ListNode middle = findMiddle(head);
     ListNode leftHead = head;
     ListNode rightHead = middle.next;
     middle.next = null;

    // step 2: sort each half
     leftHead = sortList(leftHead);
     rightHead = sortList(rightHead);

    // step 3 : merge both sorted left & right half of list
     return mergeSortedList(leftHead, rightHead);
   
    }

    ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        return slowPointer;
    }

    ListNode mergeSortedList(ListNode head1, ListNode head2){
    
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTemp = dummyHead;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while(temp1 != null && temp2 != null){
            if(temp2.val < temp1.val){
                dummyTemp.next = temp2;
                temp2 = temp2.next;
            }else{
                dummyTemp.next = temp1;
                temp1= temp1.next;
            }
            dummyTemp = dummyTemp.next;
        }

        if(temp1 != null)
            dummyTemp.next = temp1;
        
        if(temp2 != null)
            dummyTemp.next = temp2;


    return dummyHead.next;
    }

}