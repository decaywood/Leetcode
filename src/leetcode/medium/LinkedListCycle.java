package leetcode.medium;


public class LinkedListCycle {

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
            this.next = null;
        }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }
    
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            slow = slow.next;
            if(fast == null)
                return false;
            fast = fast.next;
            if(fast == null)
                return false;
            fast = fast.next;
            if(fast == slow)
                return true;
        }
    }
    
    
}
