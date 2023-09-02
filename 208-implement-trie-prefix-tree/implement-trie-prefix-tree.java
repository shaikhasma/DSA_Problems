class Node{
    private Node[] links = new Node[26];
    private boolean isEnd;

    public boolean isContains(char ch){
        return (links[ch - 'a'] != null);
    }

    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    public Node get(char ch){
        return links[ch - 'a'];
    }

    public void setAsTerminal(){
        isEnd = true;
    }

    public boolean isTerminal(){
        return isEnd;
    }

}
class Trie {
   
   private static Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.isContains(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }

        node.setAsTerminal();

    }
    
    public boolean search(String word) {
          Node node = root;
          for(int i = 0; i < word.length(); i++){
              if(!node.isContains(word.charAt(i))){
                  return false;
              }

              node = node.get(word.charAt(i));
          }
         return node.isTerminal();
    }
    
    public boolean startsWith(String prefix) {
         Node node = root;
          for(int i = 0; i < prefix.length(); i++){
              if(!node.isContains(prefix.charAt(i))){
                  return false;
              }
              node = node.get(prefix.charAt(i));
          }

         return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */