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
 /* Approach. 1 - Using Array & Two Pointer approach
 1. Iterate LinkedList and store values into array
 2. Using two pointer check array is palindrom or not

 TC - o(n) + 0(n) = 0(n)
 SC = 0(n)
 */
 
class Solution {

    public boolean isPalindrome(ListNode head) {
      ArrayList<Integer> list = new ArrayList<>();
      ListNode temp = head ;
      
      while(temp != null){
          list.add(temp.val);
          temp = temp.next;
      }
      
      int left = 0;
      int right = list.size() - 1;

      while(left < right){
          if(list.get(left) != list.get(right)){
              return false;
          }
          left++;
          right--;
      }

      return true;
    }
}