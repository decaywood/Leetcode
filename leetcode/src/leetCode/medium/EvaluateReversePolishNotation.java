package leetCode.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish
     * Notation.
     * 
     * Valid operators are +, -, *, /. Each operand may be an integer or another
     * expression.
     * 
     * Some examples:
     */

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            int ascii = token.charAt(0); // ascii: 0 -> 48 A -> 65 a -> 97
            if (ascii < 48 && token.length() == 1) {
                if (stack.size() < 2)
                    return 0;
                int tempResult = 0;
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (ascii) {
                case 43:
                    tempResult = num2 + num1;
                    break; // +
                case 45:
                    tempResult = num2 - num1;
                    break; // -
                case 42:
                    tempResult = num2 * num1;
                    break; // *
                case 47:
                    if (num1 != 0)
                        tempResult = num2 / num1;
                    break; // /
                default:
                    break;
                }
                stack.push(Integer.toString(tempResult));
            } else
                stack.push(token);

        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] str1 = new String[] { "2", "1", "+", "3", "*" };
        String[] str2 = new String[] { "4", "13", "5", "/", "+" };
        String[] str3 = new String[] { "3", "-4", "+" };
        int num = evalRPN(str3);
        System.out.println(num);

    }
}
