package easy;

/**
 * @author: decaywood
 * @date: 2015/8/24 15:02
 *
 * strstr (a.k.a find sub string), is a useful function in string operation. Your task is to implement this function.
 *
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 *
 * If target does not exist in source, just return -1.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * If source = "source" and target = "target", return -1.
 *
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 *
 * Challenge
 * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 *
 * Clarification
 * Do I need to implement KMP Algorithm in a real interview?
 *
 * Not necessary. When you meet this problem in a real interview,
 * the interviewer may just want to test your basic implementation ability.
 * But make sure your confirm with the interviewer first.
 *
 */
public class strStr {

    public static int strStr(String source, String target) {
        if(source == null || target == null || source.length() < target.length()) return -1;
        if(target.length() == 0) return 0;
        char[] src = source.toCharArray();
        char[] tar = target.toCharArray();
        for (int i = 0; i < src.length; i++) {
            if (src[i] == tar[0]) {
                int count = 1;
                for (int j = 1; j < tar.length; j++) {
                    if (i + j == src.length || src[i + j] != tar[j]) break;
                    count++;
                }
                if(count == tar.length) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", ""));
    }

}
