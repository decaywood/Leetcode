package leetcode.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null)
            return null;
        int i = 0;
        ok:
        while(true){
            if(strs.length == 0 || strs[0].length() == 0)  //防止越界
               return new String();
            if(strs[0].length() <= i)  //防止越界
                break;
            char oldChar = strs[0].charAt(i);
            for(String str : strs){
                if(str.length() <= i)
                    break ok;
                char sym = str.charAt(i);
                if(sym != oldChar)
                    break ok;
            }
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for(int j = 0; j < i; j++)
            builder.append(strs[0].charAt(j));
        return builder.toString();
    }
    
    public static void main(String[] args) {
        String[] str1 = new String[]{"12124", "12155", "1213", "121", "1214214"};
        System.out.println(longestCommonPrefix(str1));
    }
}
