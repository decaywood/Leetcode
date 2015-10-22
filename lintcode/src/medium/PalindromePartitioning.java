package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/21 22:37.
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example
 * Given s = "aab",
 *
 * Return:
 *
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 *
 */
public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(res, new ArrayList<String>(), s, 0);
        return res;
    }

    public void partition(List<List<String>> res, List<String> list, String str, int start) {
        if(start == str.length()) {
            res.add(list);
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                List<String> temp = new ArrayList<>(list);
                temp.add(str.substring(start, i + 1));
                partition(res, temp, str, i + 1);
            }
        }

    }
    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) if(str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new PalindromePartitioning().partition("");
        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

}
