package easy;

/**
 * @author: decaywood
 * @date: 2015/8/21 14:34
 *
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String val = "1";
        for (int i = 0; i < n - 1; i++)
            val = doCountAndSay(val);
        return val;
    }


    public static String doCountAndSay(String n) {
        char currentChar = '0';
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : n.toCharArray()) {
            if (currentChar != c) {
                builder.append(count).append(currentChar);
                count = 0;
                currentChar = c;
            }
            count++;
        }
        builder.append(count).append(currentChar);
        return builder.substring(2);
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
