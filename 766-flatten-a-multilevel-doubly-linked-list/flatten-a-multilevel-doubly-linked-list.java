/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
/* Approach - 1 using stack
TC- 0(N)
TC - 0(N)
*/ 
class Solution {
  
    public Node flatten(Node head) {
     Node current = head;
     Node previous = null;
     Stack<Node> stack = new Stack();

     while(current != null){
         
         if(current.child != null){
           Node child = current.child;

           if(current.next != null){
                stack.push(current.next);
                //Break previous link between next to current
                current.next.prev = null;
           }
           
           //attach child as next pointer
           current.next = child;
           //attach child prev to current
           child.prev = current;
           //break child reference of current node
           current.child = null;
         }
         //move previous & current both ahead
         previous = current;
         current = current.next;
     }

     while(!stack.isEmpty()){
       current = stack.pop();
       previous.next = current;
       current.prev= previous;

       while(current != null){
           previous = current;
           current = current.next;
       }    

     }

     return head;
    }
}