package easy;

/**
 * @author: decaywood
 * @date: 2015/10/16 15:23
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 *
 * 11 is read off as "two 1s" or 21.
 *
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Example
 * Given n = 5, return "111221".
 *
 */
public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append('1');
        for (int i = 1; i < n; i++) {
            builder = countAndSay(builder);
        }
        return builder.toString();
    }

    private StringBuilder countAndSay(StringBuilder builder) {
        StringBuilder res = new StringBuilder();
        char num = builder.charAt(0);
        int count = 0;
        for (int i = 0; i < builder.length(); i++) {
            char tempN = builder.charAt(i);
            if (num == tempN) {
                count++;
            } else {
                res.append(count).append(num);
                count = 1;
                num = tempN;
            }
        }
        res.append(count).append(num);
        return res;
    }

}
