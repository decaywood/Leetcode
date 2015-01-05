package easy;

/**
 * @author decaywood
 * 
 * 2015年1月4日
 * 
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * 
 * 实际就是26进制计算
 */
public class ExcelSheetColumnNumber {
    
    public int titleToNumber(String s) {
        
        int sum = 0;
        int length = s.length();
        
        for(int i = length - 1; i >= 0; i--){
            
            char character = s.charAt(i);
            int num = character - 'A' + 1;
            sum += num * calculateExp(length - i - 1);
            
        }
        
        return sum;
        
    }
    
    private int calculateExp(int exp){
        
        int sum = 1;
        
        while(exp-- > 0)
            sum *= 26;
        
        return sum;
        
    }
    

}
