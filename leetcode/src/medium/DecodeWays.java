package medium;

/**
 * 2014年11月16日
 * 
 * @author decaywood
 * 
 * 
 *         A message containing letters from A-Z is being encoded to numbers
 *         using the following mapping:
 * 
 *         'A' -> 1 
 *         'B' -> 2 ... 
 *         'Z' -> 26 
 *         
 *         Given an encoded message containing
 *         digits, determine the total number of ways to decode it.
 * 
 *         For example, Given encoded message "12", it could be decoded as "AB"
 *         (1 2) or "L" (12).
 * 
 *         The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    
    
    public int numDecodings(String s) {
        if(s.isEmpty())
            return 0;
        
        char before = s.charAt(0);
        
        if(s.length() == 1)
            return canDecode(before) ? 1 : 0;;
       
        char after = s.charAt(1);
        
        int consecutive = 0;
        int single = 0;
        
        if(canDecode(before) && canDecode(after) && canDecode(before, after)){
            consecutive = 1;
            single = 1;
        }
        if(canDecode(before) && !canDecode(after) && canDecode(before, after)){
             consecutive = 1;
        }
        if(canDecode(before) && canDecode(after) && !canDecode(before, after)){
            single = 1;
        }
        
        return countNumber(single, consecutive, 2, s);
    }
    
    private int countNumber(int single, int consecutive, int cursor, String s){
        
        if(cursor == s.length()){
            return single + consecutive;
        }
        
        char before = s.charAt(cursor - 1);
        char after = s.charAt(cursor);
        int tempSingle = single;
        int tempConsec = consecutive;
        
        if(canDecode(after) && canDecode(before, after)){
            tempSingle = consecutive + single;
            tempConsec = single;
        }
        if(!canDecode(after) && canDecode(before, after)){
            tempSingle = 0;
            tempConsec = single;
        }
            
        if(canDecode(after) && !canDecode(before, after)){
            tempSingle = consecutive + single;
            tempConsec = 0;
        }
       
        if(!canDecode(after) && !canDecode(before, after))
            return 0;
        
        return countNumber(tempSingle, tempConsec, cursor + 1, s);
            
    }
    
    
    private boolean canDecode(char before, char after){
        
        int beforeNumber = before - '0';
        int afterNumber = after - '0';
        int realNumber = beforeNumber * 10 + afterNumber;
        
        return realNumber <= 26 && realNumber > 9;
        
    }
    
    private boolean canDecode(char before){
        
        int beforeNumber = before - '0';
        return beforeNumber > 0 && beforeNumber <= 9;
        
    }
   //960
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("10"));
    }
}
