package leetCode.easy;

public class ReverseInteger {

    /*
     *  Example1: x = 123, return 321
     *  Example2: x = -123, return -321
     *  click to show spoilers.
     * 
     * 
     */
    
    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if(x < 0)
            sb.append("-");
        x = Math.abs(x);
        String xString = String.valueOf(x);
        int len = xString.length();
        for(int i = len-1; i >= 0; i--){
            char c = xString.charAt(i);
            sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(reverse(-12344));;
    }
}
