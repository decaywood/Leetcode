package easy;

public class ReverseWordsInAString {
    
    /*
     * Given an input string, reverse the string word by word.
     *
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * click to show clarification.
     */
    
    public static String reverseWords(String s){
        if(s == null || " ".equals(s))
            return new String();
        if(s.length() == 1){
           return s;
        }
        StringBuilder builder = new StringBuilder();
        String[] words = s.split(" ");
        for(int i = words.length-1; i >= 0; i--){
            if(words[i].equals(""))
                continue;
            builder.append(words[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
        
    }
    
    public static void main(String[] args) {
        String s = "the sky is blue";
        String var = reverseWords(s);
        System.out.println(var);
    }
}
