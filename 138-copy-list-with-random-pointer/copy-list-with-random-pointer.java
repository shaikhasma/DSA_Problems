/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/* Approach 2 Create Dummy Node in between two node with copied value
  7.    13.    11.   10.   1
7   13.    11.    10.   1

1.Traverse & Insert new node with same value between each nodes 
 - if current node != null 
 - next  = current next
 - current.next = new node
 - new node = next
2. Repeate step 1 till we reach at last node / current .next != null

3. Traverse start from head & current next wll be new head
  - current = head
  - temp = current.next

  current.next = temp.next;
  temp.next =  current.next.next;

*/
class Solution {
    public Node copyRandomList(Node head) {
     if(head == null)   return head;

    //Traverse & insert new node with same value between each node
     Node current = head;
     while(current != null){
         Node newNode = new Node(current.val);
         newNode.next =  current.next;
         
         current.next = newNode;
         
         //move next
         current = newNode.next;
     }

     current = head;
     while(current != null){
        if(current.random != null){
            current.next.random = current.random.next;
        }

        current = current.next.next;
     }
     // Traverse & attah all new node in LL seq & old node in previouw LL sequence
     
     Node dummyHead = new Node(-1);
     current = head;
     Node dummyTemp = dummyHead;

     while(current != null){
       Node oldNext = current.next.next;
       dummyTemp.next = current.next;  
       current.next = oldNext;

       dummyTemp = dummyTemp.next ;
       current = oldNext;
     } 

     return dummyHead.next;
    }
}