package easy;

public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
     * number of rows like this: (you may want to display this pattern in a
     * fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * Write the code that will take a string and make this conversion given a
     * number of rows:
     * 
     * string convert(string text, int nRows);
     * 
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    
    public String convert(String s, int nRows) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= nRows; i++){
            sb.append(readLine(s, i, nRows));
        }
        return sb.toString();
    }
    
    private String readLine(String s, int row, int nRows){
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int index = row;
        int time = 1;
        while (index <= len) {
            sb.append(s.charAt(index - 1));
            index = row + (nRows - row) * 2 * time;
            time++;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        new ZigZagConversion().convert("PAYPALISHIRING", 3);
    }
}
