package leetcode.medium;

/**
 * @author: decaywood
 * @date: 2015/8/11 19:46
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 */
public class AddAndSearchWord {

    private static class CharNode {
        boolean end;
        char nodeVal;
        CharNode[] charNodes = new CharNode[26];
        public void addWord(char[] chars, int index) {
            if (index < chars.length) {
                char c = chars[index];
                int nodeIndex = c - 'a';
                if(charNodes[nodeIndex] == null) charNodes[nodeIndex] = new CharNode();
                CharNode charNode = charNodes[nodeIndex];
                charNode.nodeVal = c;
                if(index == chars.length - 1) charNode.end = true;
                charNode.addWord(chars, ++index);
            }
        }

        public boolean search(char[] chars, int index) {

            char c = chars[index];
            int nodeIndex = c - 'a';

            if (c == '.') {
                boolean result = false;
                for (CharNode charNode : charNodes) {
                    if(charNode == null) continue;
                    if(index == chars.length - 1) {
                        if(charNode.end) return true;
                        else continue;
                    }
                    result |= charNode.search(chars, index + 1);
                }
                return result;
            } else if (charNodes[nodeIndex] != null && c == charNodes[nodeIndex].nodeVal) {
                CharNode charNode = charNodes[c - 'a'];
                if(index == chars.length - 1) return charNode.end;
                return charNode.search(chars, ++index);
            }
            return false;
        }
    }

    CharNode charNode = new CharNode();
    public void addWord(String word) {
        charNode.addWord(word.toCharArray(), 0);
    }

    public boolean search(String word) {
        return charNode.search(word.toCharArray(), 0);
    }



}
