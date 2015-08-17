package hard;

import dataStructure.ListNode;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author: decaywood
 * @date: 2015/8/17 13:18.
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 */
public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode n : lists) {
            if(n == null) continue;
            queue.offer(n);
        }
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            node.next = min;
            node = node.next;
            if(min.next != null) queue.offer(min.next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        mergeKLists(new ListNode[]{null, null});
    }
}
