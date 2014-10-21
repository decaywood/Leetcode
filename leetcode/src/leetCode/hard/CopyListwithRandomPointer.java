package leetCode.hard;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    /**
     * A linked list is given such that each node contains an additional random
     * pointer which could point to any node in the list or null.
     * 
     * Return a deep copy of the list.
     * 
     */

    /**
     * Definition for singly-linked list with a random pointer. class
     * RandomListNode { int label; RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; } };
     */

    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };

    /**
     * 思路一： 1： 创造新旧节点一对一映射 2： 根据旧节点构建新节点引用
     * 
     * 思路二：
     * 该算法更为巧妙，不用保存原始链表的映射关系，构建新节点时，指针做如下变化，即把新节点插入到相应的旧节点后面： 同理分两步
     * 
     * 1、构建新节点random指针：new1->random = old1->random->next, new2-random = NULL,
     * new3-random = NULL, new4->random = old4->random->next
     * 
     * 2、恢复原始链表以及构建新链表：例如old1->next = old1->next->next, new1->next =
     * new1->next->next
     * 
     * 该算法时间复杂度O(N)，空间复杂度O(1)
     */
    private Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = head;
        while (p != null) {
            RandomListNode next = map.get(p.next);
            RandomListNode random = map.get(p.random);
            RandomListNode newOne = map.get(p);
            newOne.next = next;
            newOne.random = random;
            p = p.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        node.next = node2;
        node2.next = node;

        new CopyListwithRandomPointer().copyRandomList(node);
    }

}
