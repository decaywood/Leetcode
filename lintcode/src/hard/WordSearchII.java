package hard;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/10/10 20:42.
 *
 * Given a matrix of lower alphabets and a dictionary.
 * Find all words in the dictionary that can be found in the matrix.
 * A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
 *
 * Example
 * Given matrix:
 *  doaf
 *  agai
 *  dcan
 * and dictionary:
 * {"dog", "dad", "dgdg", "can", "again"}
 *
 * return {"dog", "dad", "can", "again"}
 *
 * dog:  dad:  can:  again:
 * doaf  doaf  doaf  doaf
 * agai  agai  agai  agai
 * dcan  dcan  dcan  dcan
 *
 * Challenge
 * Using trie to implement your algorithm.
 *
 */
public class WordSearchII {

    private static class Trie {
        boolean word;
        Character character;
        Map<Character, Trie> trieMap = new HashMap<>();

        private void buildTrie(String word, int index) {
            if(index == word.length()) return;
            Character c = word.charAt(index);
            if (!trieMap.containsKey(c)) {
                Trie trie = new Trie();
                trie.character = c;
                trieMap.put(c, trie);
            }
            if(!trieMap.get(c).word) trieMap.get(c).word = index == word.length() - 1;
            trieMap.get(c).buildTrie(word, index + 1);
        }

        private Trie get(Character c) {
            return trieMap.get(c);
        }
    }

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Trie root = new Trie();
        Set<String> res = new HashSet<>();
        Trie[][] trieBoard = new Trie[board.length][board[0].length];
        for (String word : words) root.buildTrie(word, 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                trieBoard[i][j] = root.get(board[i][j]);
            }
        }

        for (int i = 0; i < trieBoard.length; i++) {
            for (int j = 0; j < trieBoard[i].length; j++) {
                Trie trie = trieBoard[i][j];
                if (trie == null) continue;
                doSearch(res, board, trie, i, j, new StringBuilder());
            }
        }

        return new ArrayList<>(res);

    }

    private void doSearch(Set<String> res, char[][] board, Trie trie, int i, int j, StringBuilder builder) {
        builder.append(trie.character);
        if(trie.word) res.add(builder.toString());
        Trie next;
        Character c = board[i][j];
        if (i > 0 && (next = trie.get(board[i - 1][j])) != null) {
            board[i][j] = '*';
            doSearch(res, board, next, i - 1, j, new StringBuilder(builder));
            board[i][j] = c;
        }
        if (i != board.length - 1 && (next = trie.get(board[i + 1][j])) != null) {
            board[i][j] = '*';
            doSearch(res, board, next, i + 1, j, new StringBuilder(builder));
            board[i][j] = c;
        }
        if (j > 0 && (next = trie.get(board[i][j - 1])) != null) {
            board[i][j] = '*';
            doSearch(res, board, next, i, j - 1, new StringBuilder(builder));
            board[i][j] = c;
        }
        if (j != board[i].length - 1 && (next = trie.get(board[i][j + 1])) != null) {
            board[i][j] = '*';
            doSearch(res, board, next, i, j + 1, new StringBuilder(builder));
            board[i][j] = c;
        }

    }

/*
    public static void main(String[] args) {
        String[] b = new String[]{"abce","sfcs","adee"};
        char[][] board = new char[b.length][];
        for (int i = 0; i < b.length; i++) {
            board[i] = b[i].toCharArray();
        }
        ArrayList<String> list = new ArrayList<>();
        for (String s : new String[]{"see","se"}) {
            list.add(s);
        }
        new WordSearchII().wordSearchII(board, list);
    }*/
}
