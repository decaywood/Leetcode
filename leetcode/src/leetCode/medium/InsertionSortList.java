package leetCode.medium;


public class InsertionSortList {
    
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
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
    
    private static ListNode insertNode(ListNode before, ListNode after, ListNode preNode){
        ListNode node = after.next;
        preNode.next = after.next;
        after.next = before.next;
        before.next = after;
        return node;
    }
    
    private static ListNode findInsertPos(ListNode root, ListNode target){
        ListNode preNode = root;
        ListNode head = root.next;
        preNode.next = head;
        while(head != target && head.val <= target.val){
            head = head.next;
            preNode = preNode.next;
        }
        return preNode;
    }
    
    public static ListNode insertionSortList(ListNode head) {
        if(head.next == null)
            return head;
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode preNode = root;
        ListNode start = head;
        root.next = head;
        start = start.next;
        preNode = preNode.next;
        while(start != null){
            ListNode pos = findInsertPos(root, start);
            if(pos.next != start){
                start = insertNode(pos, start, preNode);
                continue;
            }
            start = start.next;
            preNode = preNode.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
      ListNode node = new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(2, new ListNode(8, new ListNode(7, new ListNode(2, null)))))));
      insertionSortList(node);
    }
}
