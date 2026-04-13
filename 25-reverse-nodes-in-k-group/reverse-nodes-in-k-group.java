/*
 Approach 2 - Find Kth element cut link and reverse it

 TC - 0(N) + 0(N)
   -0(2n)
   - 0(N)

SC - 0(N)

*/
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // Step 1: Find kth node
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break; // less than k nodes left

            ListNode nextGroupStart = kth.next;

            // Step 2: Cut the group
            kth.next = null;

            // Step 3: Reverse current group
            ListNode groupStart = prevGroupEnd.next;
            ListNode reversedHead = reverse(groupStart);

            // Step 4: Attach back
            prevGroupEnd.next = reversedHead;
            groupStart.next = nextGroupStart;

            // Step 5: Move prevGroupEnd
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Helper to find kth node from current
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    // Standard reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}