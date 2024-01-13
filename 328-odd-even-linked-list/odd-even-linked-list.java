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
 /*Approach - 1 using two list and join those two list
 1. create new list which hold odd nodes
 2. create another list which hold even nodes
 3. Attach 2nd list to last of 1st list 
 4. return head
 TC - 0(n) + 0(n)
 SC - 0(n) 

 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        if(head == null || head.next == null)
            return head;
        fillOddNodes(head, arr);
        fillEvenNodes(head, arr);
      
        //copy values from temp llist to original linked list
        temp = head;
        for(int index = 0; index < arr.size(); index++){
            temp.val = arr.get(index);
            temp = temp.next;
        }

        return head;
    }

   void fillOddNodes(ListNode head, ArrayList<Integer> list){
      // starting copying odd list nodes 
       ListNode temp = head;
        while(temp != null && temp.next != null){
            list.add(temp.val);
            temp = temp.next.next;
        } 

        // To add the last element if it's odd length
        if(temp != null)
            list.add(temp.val);
        
   }
    void fillEvenNodes(ListNode head, ArrayList<Integer> list){
        // starting copying even list nodes 
        ListNode temp = head.next;
        while(temp != null && temp.next != null){
            list.add(temp.val);
            temp = temp.next.next;
        }

        if(temp != null)
            list.add(temp.val);
    
    }
}