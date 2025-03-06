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
    /*
    // ✅ Method to get top 5 words that start with a given prefix
    public List<String> top5WordsWithPrefix(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.isContains(ch)) {
                return Collections.emptyList();
            }
            node = node.get(ch);
        }

        List<String> words = new ArrayList<>();
        dfs(node, words);
        return words;
    }

    // Helper DFS method to collect words
    private void dfs(Node node, List<String> words) {
        if (node == null || words.size() >= 5) return;
        
        if (node.isTerminal()) {
            words.add(node.getWord());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.isContains(ch)) {
                dfs(node.get(ch), words);
            }
        }
    }
   }
   */
   
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */