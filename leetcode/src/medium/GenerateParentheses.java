package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/30 16:05
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void generateParenthesis(List<String> res, StringBuilder builder, int leftCount, int rightCount, int n) {
        if(leftCount > n || rightCount > n || leftCount < rightCount) return;
        if(leftCount == n && rightCount == n) {
            res.add(builder.toString());
            return;
        }
        StringBuilder temp = new StringBuilder(builder);
        temp.append('(');
        generateParenthesis(res, temp, leftCount + 1, rightCount, n);
        temp = new StringBuilder(builder);
        temp.append(')');
        generateParenthesis(res, temp, leftCount, rightCount + 1, n);
    }

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(0);
    }

}
