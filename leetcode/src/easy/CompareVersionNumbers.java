package easy;

/**
 * @author decaywood
 * 
 * 2015年1月23日
 * 
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * 思路：将字符串以"."拆开，得到String数组
 * 将数组中元素一一对比，若数组长度不一，以0补齐
 * 再进行大小比较即可
 * 
 */
public class CompareVersionNumbers{
    
    public static int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        
        for(int i = 0; i < len; i++){
            String s1 = i < v1.length ? v1[i] : "0";
            String s2 = i < v2.length ? v2[i] : "0";
            int check = check(s1, s2);
            if(check == 0) continue;
            return check;
        }
        return 0;
    }
    
    private static int check(String v1, String v2){
        
        long value1 = Long.valueOf(v1);
        long value2 = Long.valueOf(v2);
        return value1 == value2 ? 0 : value1 > value2 ? 1 : -1;
        
    }
    
    public static void main(String[] args) {
        System.out.println(compareVersion("3", "3.1"));
    }
    
    
    
}
