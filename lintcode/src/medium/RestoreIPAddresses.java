package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2016/1/27 9:58
 *
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 *
 * Example
 * Given "25525511135", return
 *
 * [
 *  "255.255.11.135",
 *  "255.255.111.35"
 * ]
 * Order does not matter.
 *
 */
public class RestoreIPAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        doRestore(arrayList, 0, 0, s, "");
        return arrayList;
    }

    private void doRestore(ArrayList<String> addresses, int index, int level, String str, String candidate) {
        if(level > 4) return;
        level++;
        if(index == str.length() && level == 5) {
            addresses.add(candidate.substring(0, candidate.length() - 1));
            return;
        }
        for (int i = 3; i >= 1; i--) {
            if(index + i > str.length()) continue;
            String sub = str.substring(index, index + i);
            if(sub.length() > 1 && sub.charAt(0) == '0') continue;
            int num = Integer.parseInt(sub);
            if (num <= 255) {
                doRestore(addresses, index + i, level, str, candidate + num + ".");
            }
        }
    }

}
