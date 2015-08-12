package leetcode.easy;


/**
 * 2014年11月12日
 * 
 * @author decaywood
 * 
 *         Design a stack that supports push, pop, top, and retrieving the
 *         minimum element in constant time.
 * 
 *         push(x) -- Push element x onto stack. 
 *         pop() -- Removes the element on top of the stack. 
 *         top() -- Get the top element. 
 *         getMin() -- Retrieve the minimum element in the stack.
 * 
 */
public class MinStack {
    
    private class Node {  
        int val;  
        int min;  
        Node next;  
        public Node(int val) {  
            this.val = val;  
        }  
    }
    
    Node top = null;  
    
    public void push(int x) {  
        if (top == null) {  
            top = new Node(x);  
            top.min = x;  
        } else {  
            Node temp = new Node(x);  
            temp.next = top;  
            top = temp;  
            top.min = Math.min(top.next.min, x);  
        }  
    }  
  
    public void pop() {  
        top = top.next;  
        return;  
    }  
  
    public int top() {  
        return top == null ? 0 : top.val;  
    }  
  
    public int getMin() {  
        return top == null ? 0 : top.min;  
    }  
    
}
