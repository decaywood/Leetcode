package medium;


import dataStructure.ListNode;

public class SortLinkedList {
        

    
 
    public static ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        ListNode doubleSpeed = head;
        ListNode temp1 = head;
        ListNode temp2 = null;
        ListNode node = null;
        while(doubleSpeed != null && doubleSpeed.next != null){  // 双指针法取中间节点
            temp2 = temp1;
            temp1 = temp1.next;
            if(doubleSpeed.next != null)
                doubleSpeed = doubleSpeed.next.next;
        }
        node = temp2.next;
        temp2.next = null;
        ListNode head1 = null;
        ListNode head2 = null;
        
        if(head.next != null)
            head1 = sortList(head);  //递归调用左边部分
        else 
            head1 = head;
        if(node.next != null)
            head2 = sortList(node);  //递归调用右边部分
        else 
            head2 = node;
        
        ListNode tempHead = new ListNode(Integer.MIN_VALUE);  //比较与合并
        ListNode result = tempHead;
        while(head1 != null || head2 != null){
            if(head1 != null){
                if(head2 == null || head1.val <= head2.val){
                    tempHead.next = head1;
                    head1 = head1.next;
                    tempHead = tempHead.next;
                }
            }
            if(head2 != null){
                if(head1 == null || head2.val <= head1.val){
                    tempHead.next = head2;
                    head2 = head2.next;
                    tempHead = tempHead.next;
                }
            }
        }
        result = result.next;
        return result;
    }
    
    public static void main(String[] args) {
//        ListNode node = new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(8, new ListNode(7, new ListNode(2, null)))))));
//        sortList(node);
    }
}
