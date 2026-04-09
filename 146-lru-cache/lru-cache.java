class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
     Node head = new Node(0,0);
     Node tail = new Node(0,0);
    int capacity = 0;

    static class Node{
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }

    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
       
        head.next =tail;
        tail.prev = head;     
    }
    
    public int get(int key) {
       if(map.containsKey(key)){
        Node node = map.get(key);

        removeNode(node);
        insertNextToHead(node);

        return node.val;
       }else
          return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);

        if(map.containsKey(key))
            removeNode(map.get(key));

        if(capacity == map.size())
            removeNode(tail.prev);

        map.put(key,node);
        insertNextToHead(node);
    }

    void removeNode(Node node){
      map.remove(node.key);
      
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

     void insertNextToHead(Node node){
      map.put(node.key, node);

      node.next = head.next;
      head.next.prev = node;
      
      head.next = node;
      node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */