package leetCode.easy;

public class MergeTowSortedLists {

    /**
     * 
     * Merge two sorted linked lists and return it as a new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     * 
     * Definition for singly-linked list.
      
    
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
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode ret = null;
        
        if(l1.val < l2.val){
            ret = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }
        else {
            ret = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        
        return ret;
    }
    
}
