package easy;

/**
 * @author decaywood
 * 
 * 2015年1月4日
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB 
 * 
 * 注意：Z为特殊情况，故 divider - 1解决
 * 
 */
public class ExcelSheetColumnTitle {
    
    public static String convertToTitle(int n) {
        
        int divider = n;
        StringBuilder builder = new StringBuilder();
        
        while(divider > 0){
            int num = (divider - 1) % 26;
            char character = (char) ('A' + num);
            builder.append(character);
            divider = (divider - 1) / 26;
        }
        
        return builder.reverse().toString();
            
    }
    
    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
    
    
}
