package easy;

/**
 * @author: decaywood
 * @date: 2015/8/23 9:58.
 *
 * Write a method to replace all spaces in a string with %20.
 * The string is given in a characters array,
 * you can assume it has enough space for replacement and you are given the true length of the string.
 *
 * Given "Mr John Smith", length = 13.
 *
 * The string after replacement should be "Mr%20John%20Smith".
 *
 * Note
 * If you are using Java or Python£¬please use characters array instead of string.
 *
 * Challenge
 * Do it in-place.
 *
 */
public class SpaceReplacement {

    public int replaceBlank(char[] string, int length) {
        if(string == null || string.length == 0) return 0;
        int spaceCount = 0;
        for (char c : string) if(c == ' ') spaceCount++;
        int newLength = length + spaceCount * 2;
        for (int i = length - 1, j = newLength - 1; i >= 0 ; i--) {
            char c = string[i];
            if(c != ' ') string[j--] = string[i];
            else {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
            }
        }
        return newLength;
    }


}
