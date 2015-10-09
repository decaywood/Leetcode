package medium;

import dataStructure.ListNode;

import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/9 22:07.
 *
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Analyze and describe its complexity.
 *
 * Example
 * Given lists:
 *
 * [
 *  2->4->null,
 *  null,
 *  -1->null
 * ],
 *
 * return -1->2->4->null.
 */
public class MergekSortedLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.isEmpty()) return null;

        ListNode dummyNode = new ListNode(0);
        ListNode tempNode = dummyNode;
        while (true) {
            int index = 0;
            int nullCount = 0;
            for (int i = 0,  min = Integer.MAX_VALUE; i < lists.size(); i++) {
                ListNode node = lists.get(i);
                if (node == null) {
                    nullCount++;
                    continue;
                }
                if (min > node.val) {
                    min = node.val;
                    index = i;
                }
            }
            if(nullCount == lists.size()) break;
            tempNode.next = lists.get(index);
            tempNode = tempNode.next;
            lists.set(index, lists.get(index).next);
        }
        return dummyNode.next;
    }


}
