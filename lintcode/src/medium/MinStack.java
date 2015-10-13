package medium;

import java.util.Stack;

/**
 * @author: decaywood
 * @date: 2015/10/10 10:12
 * <p>
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * <p>
 * It should support push, pop and min operation all in O(1) cost.
 * <p>
 * Example
 * Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
 * <p>
 * Note
 * min operation will never be called if there is no number in the stack
 */
public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        minStack.push(min);
        min = Math.min(min, number);
        stack.push(number);
    }


    public int pop() {
        min = minStack.pop();
        return stack.pop();
    }

    public int min() {
        return min;
    }


}
