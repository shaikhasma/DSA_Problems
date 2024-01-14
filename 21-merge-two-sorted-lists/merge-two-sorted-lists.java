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