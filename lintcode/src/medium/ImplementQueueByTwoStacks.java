package medium;

import java.util.Stack;

/**
 * @author: decaywood
 * @date: 2015/10/10 10:02
 *
 * As the title described, you should only use two stacks to implement a queue's actions.
 *
 * The queue should support push(element),
 * pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 *
 * Both pop and top methods should return the value of first element.
 *
 * Example
 * For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2
 *
 * Challenge
 * implement it by two stacks, do not use any other data structure and push,
 * pop and top should be O(1) by AVERAGE.
 *
 */
public class ImplementQueueByTwoStacks {

    private Stack<Integer> pop;
    private Stack<Integer> push;

    public ImplementQueueByTwoStacks() {
        this.pop = new Stack<>();
        this.push = new Stack<>();
    }

    public void push(int element) {
        push.push(element);
    }

    public int pop() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) pop.push(push.pop());
        }
        return pop.pop();
    }

    public int top() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) pop.push(push.pop());
        }
        return pop.peek();
    }


}
