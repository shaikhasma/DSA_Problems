class Node {
    String url;
    Node next ;
    Node prev;
    
   public Node (String url){
      this.url = url;
   }
}
class BrowserHistory {
    Node currentPage;

    public BrowserHistory(String homepage) {
      currentPage = new Node (homepage);         
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        currentPage = currentPage.next;
    }
    
    public String back(int step) {
        while(step > 0){
            if(currentPage.prev != null){
                currentPage = currentPage.prev;
                step--;
            }else{
                break;
            }
        }
        return currentPage.url;
    }
    
    public String forward(int step) {
        while(step > 0){
            if(currentPage.next!= null){
                currentPage = currentPage.next;
                step--;
            }else{
                break;
            }
        }
        return currentPage.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */