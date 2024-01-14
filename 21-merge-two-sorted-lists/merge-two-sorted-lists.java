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
 /*Approach 1 - using ArrayList
 1. copy all the list & list2 node values into new arrayList
 2. sort arrayList
 3. create new linked list and copy arraylist values into that

 TC - 0(N1) + 0(n2) + o(nlogn) + 0(n)
      list1.   list2     sort.    fill new ll
 SC - 0(N) + 0(N) arraylist + new linked list 

 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ArrayList<Integer> list = new ArrayList<>();
        fillArray(list1, list);
        fillArray(list2, list);

        Collections.sort(list);

        return toLinkedList(list);
        
    }
    void fillArray(ListNode head,ArrayList<Integer> list){
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
    }

    ListNode toLinkedList(ArrayList<Integer> list){

        ListNode head = new ListNode(list.get(0));
        ListNode temp = head;
        for(int index = 1; index < list.size(); index++){
            temp.next = new ListNode(list.get(index));
            temp = temp.next;
        }

        return head;
    }
}