package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/11/8 9:05.
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
 * means it can represent any one letter.
 *
 * Example
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 */
public class AddAndSearchWord {

    private static class Trie {
        char c;
        boolean isWord;
        Map<Character, Trie> trieMap = new HashMap<>();
    }

    private void addWord(Trie root, String word, int index) {
        Character c = word.charAt(index);
        Map<Character, Trie> trieMap = root.trieMap;
        Trie trie = trieMap.containsKey(c) ? trieMap.get(c) : new Trie();
        trie.c = word.charAt(index);
        trie.isWord |= index == word.length() - 1;
        trieMap.put(word.charAt(index), trie);
        if (index < word.length() - 1) addWord(trieMap.get(c), word, index + 1);
    }

    private boolean search(Trie root, String word, int index) {
        if(root == null) return false;
        Character c = word.charAt(index);
        Map<Character, Trie> trieMap = root.trieMap;
        if (c == '.') {
            for (Trie trie : trieMap.values()) {
                if (index == word.length() - 1 && trie.isWord) return true;
                else if(index + 1 < word.length() && search(trie, word, index + 1)) return true;
            }
            return false;
        }
        else return index == word.length() - 1 ? trieMap.containsKey(c) && trieMap.get(c).isWord : search(trieMap.get(c), word, index + 1);
    }

    private Trie root = new Trie();

    public void addWord(String word) {
        addWord(root, word, 0);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }



}
