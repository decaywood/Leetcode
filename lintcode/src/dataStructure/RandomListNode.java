package dataStructure;

/**
 * @author: decaywood
 * @date: 2015/9/2 19:49.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class RandomListNode {

    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }
    public RandomListNode(int x, RandomListNode next) {
        this.label = x;
        this.next = next;
    }

}
