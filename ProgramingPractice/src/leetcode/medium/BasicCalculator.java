package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/8/7 11:25
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 *"(112+(423-52+212)-333)+(61+81)"
 *
 */
public class BasicCalculator {


    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int rs = 0;
        int sign = 1;
        stack.push(1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') continue;
            else if (s.charAt(i) == '('){
                stack.push(stack.peekFirst() * sign);
                sign = 1;
            }
            else if (s.charAt(i) == ')') stack.pop();
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else{
                int temp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    temp = temp * 10 + s.charAt(++i) - '0';
                rs += sign * stack.peekFirst() * temp;
            }
        }
        return rs;
    }




    public static void main(String[] args) {
        calculate("(-112-(423-52+212)-333)+(61+81)");
    }

}
