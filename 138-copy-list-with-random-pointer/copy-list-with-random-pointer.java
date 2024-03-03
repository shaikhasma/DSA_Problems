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
/* Approach 1 Using Hashing & Store original node as key all cloned node as value
1. Traverse LL 
  -  store orignal node as key and its copy as value
      so, next time while creating deep copy we can refere next node & its random node from map value
2. Traverse LL 
 - Attach next node reference  & random node reference to copied node

3. Get head node value from map that is our copies head node return it

TC - 0(N) + 0(N)
   - 2n
   = 0(n)
SC - 0(N)
*/
class Solution {
    public Node copyRandomList(Node head) {
       if(head == null)
        return null;

        HashMap<Node, Node> randomRef = new HashMap<>();
        Node temp = head;
        while(temp != null){
            randomRef.put(temp, new Node(temp.val));
            temp = temp.next;
        }      

    
        temp = head;
        while(temp != null){
            Node newNode = randomRef.get(temp);
            newNode.next = (temp.next != null) ? randomRef.get(temp.next): null;
            newNode.random = (temp.random != null) ? randomRef.get(temp.random):null;
          

            temp = temp.next;
        

        }

        return randomRef.get(head);

    }
}