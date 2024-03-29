/* Approach - Using Doubly Linked List
1. Create Node structure 
   - String val
   - prev Node ref
   - next Node ref

2. Create currentPage of Node type in BrowserHistory
  - constructor new a new page and that will be current page
  TC- 0(1)
  
3. Visit simply add new Node 
- current.next = new Node
- move current to new node

4. Back N steps
- move current page to N step back
- return current page name
TC- 0(N)

5. Forward N Steps
- move current page to N step ahead
- return current page name
TC- 0(n)


*/
class Node{
     
     String val;
     Node prev;
     Node next;

     public Node(String val ){
       this.val = val;
     }
     public Node getNext(){
         return this.next;
     }

     public Node getPrev(){
         return this.prev;
     }
 
     public String getVal(){
         return this.val;
     }
}


class BrowserHistory {
     Node currentPage;
   
    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        currentPage.next= newNode;
        newNode.prev= currentPage;
        currentPage = currentPage.next;
    }
    
    public String back(int steps) {
     
        while(steps > 0){
          
          if(currentPage.getPrev() == null){
              break;
          }else{
           currentPage = currentPage.getPrev(); 
           steps--;    
          }

        }
        return currentPage.val;
       
    }
    
    public String forward(int steps) {
        while(steps > 0){
          
          if(currentPage.getNext()== null){
              break;
          }else{
           currentPage = currentPage.getNext();  
           steps--;   
          }

        }
        return currentPage.val;
       
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */