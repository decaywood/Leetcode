package medium;

import dataStructure.ListNode;
import dataStructure.RandomListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 19:50.
 *
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Example
 * Challenge
 * Could you solve it with O(1) space?
 *
 */
public class CopyListWithRandomPointer {

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode temp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = temp;
            node = temp;
        }
        RandomListNode res = head.next;
        node = head;
        while (node != null) {
            RandomListNode newNode = node.next;
            newNode.random = node.random == null ? null : node.random.next;
            node = newNode.next;
        }
        node = head;
        while (node != null) {
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            node = node.next;
        }
        return res;
    }


}
