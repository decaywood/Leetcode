package leetcode.easy;

import java.util.Stack;

/**
 * @author: decaywood
 * @date: 2015/7/26 11:03
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 *
 * Notes:
 *
 * You must use only standard operations of a stack
 * -- which means only push to top, peek/pop from top,
 * size, and is empty operations are valid.
 *
 * Depending on your language, stack may not be supported natively.
 * You may simulate a stack by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a stack.
 * You may assume that all operations are valid
 * (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty() && stack2.isEmpty();
    }

}
