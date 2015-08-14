package hard;

/**
 * @author: decaywood
 * @date: 2015/8/14 10:06
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s3.length() == 1) return s1.equals(s3) || s2.equals(s3);
        char[] chars1 = ("#" + s1 + "#").toCharArray();
        char[] chars2 = ("#" + s2 + "#").toCharArray();
        char[] chars3 = s3.toCharArray();

        int[][] stepTable = new int[s1.length() + 2][];
        for (int i = 0; i < stepTable.length; i++) {
            stepTable[i] = new int[s2.length() + 2];
        }
        stepTable[0][0] = -1;

        for (int i = 0; i < chars1.length - 1; i++) {
            char c1 = chars1[i + 1];
            boolean bothNotMatch = false;
            for (int j = 0; j < chars2.length - 1; j++) {
                char c2 = chars2[j + 1];
                int step = stepTable[i][j];
                if(step + 1 == s3.length()) return true;
                char c3 = chars3[step + 1];
                if(c1 == c3) {
                    bothNotMatch = true;
                    stepTable[i + 1][j] = step + 1;
                }
                if(c2 == c3) {
                    bothNotMatch = true;
                    if(step + 1 > stepTable[i][j + 1])
                        stepTable[i][j + 1] = step + 1;
                }
            }
            if(!bothNotMatch) return false;
        }
        return false;
    }

    private static void printMatrix(int[][] stepTable) {
        System.out.println("---------------------");
        for (int x = stepTable.length - 1; x >= 0; x--) {
            int[] i = stepTable[x];
            for (int s : i) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
   /*  recurse version


    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    public static boolean isInterleave(String s1, int index1, String s2, int index2, String s3, int index3) {
        if(index3 == s3.length()) return true;
        char c3 = s3.charAt(index3);
        boolean legal1 = false;
        boolean legal2 = false;
        if (index1 < s1.length() && s1.charAt(index1) == c3) {
            legal1 = isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1);
        }

        if (index2 < s2.length() && s2.charAt(index2) == c3) {
            legal2 = isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1);
        }
        return legal1 || legal2;
    }


     private static void printMatrix(int[][] stepTable) {
        System.out.println("---------------------");
        for (int x = stepTable.length - 1; x >= 0; x--) {
            int[] i = stepTable[x];
            for (int s : i) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }


    */


    public static void main(String[] args) {
        System.out.println(isInterleave("cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc", "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb", "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("db", "b", "cbb"));
    }
}
