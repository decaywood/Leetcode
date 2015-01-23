package easy;

/**
 * @author decaywood
 * 
 * 2015年1月23日
 * 
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 */
public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        
        if(haystack == "" && needle == "") return 0;
        if(needle.length() > haystack.length()) return -1;
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            int count = 0;
            for(int iHaystack = i, iNeedle = 0; iNeedle < needle.length(); iHaystack++, iNeedle++){
                char cHaystack = haystack.charAt(iHaystack);
                char cNeedle = needle.charAt(iNeedle);
                if(cHaystack != cNeedle) break;
                count++;
            }
            if(count == needle.length()) return i;
        }
        
        return -1;
        
    }
    
    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "baaaa"));
    }
    
}
