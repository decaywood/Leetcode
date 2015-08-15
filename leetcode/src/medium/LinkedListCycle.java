package medium;


import dataStructure.ListNode;

public class LinkedListCycle {


    
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
