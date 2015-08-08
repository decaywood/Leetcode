package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/8/7 10:50
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back,
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 *
 *
 */
public class ImplementStackUsingQueues {

    private Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        int count = 1;
        while (count++ < queue.size()) {
            queue.offer(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues queues = new ImplementStackUsingQueues();
        queues.push(1);
        queues.push(2);
        queues.push(33);
        System.out.println(queues.top());
    }

}
