package medium;


public class LinkedListCycleII {

    /**
     * 判断一个链表是否存在环有一个简单的方法，就是使用一个快指针、和一个慢指针，快指针每次走两步，慢指针每次走一步，则如果有环，它们最后必然会相遇的。
     * 本题的难点在于要找出环的起点
     * 。其实也不难，与判断是否有环类似，用两个步长分别为1和2的指针遍历链表，直到两者相遇，此时慢指针走过的长度就是环的长度。
     * 另外相遇后把其中指针重新设定为起始点，让两个指针以步长1再走一遍链表，相遇点就是环的起始点。 证明也很简单，证明如下：
     * 
     * 我们注意到第一次相遇时
     * 
     * 慢指针走过的路程S1 = 非环部分长度 + 弧A长
     * 
     * 快指针走过的路程S2 = 非环部分长度 + n * 环长 + 弧A长
     * 
     * S1 * 2 = S2，可得 非环部分长度 = n * 环长 - 弧A长
     * 
     * 让指针A回到起始点后，走过一个非环部分长度，指针B走过了相等的长度，也就是n * 环长 - 弧A长，正好回到环的开头。
     */
    
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *     }
     * }
     */
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
    
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow)
                break;
        }
        slow = head;
        while (quick != slow) {
            if(slow == null || quick == null)
                return null;
            slow = slow.next;
            quick = quick.next;
        }
        return quick;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node2 = new ListNode(2);
        node.next = node2;
//        node2.next = node;
        new LinkedListCycleII().detectCycle(node);
    }
}
