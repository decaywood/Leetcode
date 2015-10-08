package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/30 10:50
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("somestring");
 * trie.search("key");
 *
 */


public class ImplementTriePrefixTree {

    class TrieNode {

        boolean contain = false;
        private Map<Character, TrieNode> map;
        public TrieNode() {map = new HashMap<>();}
        public void insert(String word, int index) {
            if(index == word.length()) contain = true;
            if(word.length() == 0 || index == word.length()) return;
            Character c = word.charAt(index);
            if (!map.containsKey(c)) map.put(c, new TrieNode());
            map.get(c).insert(word, ++index);
        }

        public boolean search(String word, int index) {
            if (index == word.length()) return contain;
            Character c = word.charAt(index);
            return map.containsKey(c) && map.get(c).search(word, ++index);
        }

        public boolean startsWith(String prefix, int index) {
            if(index == prefix.length()) return contain || !map.isEmpty();
            Character c = prefix.charAt(index);
            return map.containsKey(c) && map.get(c).startsWith(prefix, ++index);
        }
    }

    private TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word, 0);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree triePrefixTree = new ImplementTriePrefixTree();
        triePrefixTree.insert("jam");
        triePrefixTree.insert("rental");
        System.out.println(triePrefixTree.startsWith("ren"));
    }
}


