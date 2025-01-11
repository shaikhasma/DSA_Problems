import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> dict = new HashMap<>();
    int startCount = 0;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.dict.putIfAbsent(c, new TrieNode());
            current = current.dict.get(c);
            current.startCount++;
        }
    }

    public int startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.dict.containsKey(c)) {
                return 0;
            }
            current = current.dict.get(c);
        }
        return current.startCount;
    }
}

public class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        return trie.startsWith(pref);
    }
}