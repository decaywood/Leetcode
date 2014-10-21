package leetCode.medium;


public class AddTwoNumbers {

    /**
     * You are given two linked lists representing two non-negative numbers. The
     * digits are stored in reverse order and each of their nodes contain a
     * single digit. Add the two numbers and return it as a linked list.
     * 
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
     * 
     * Tips:  465 + 342 = 807
   
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
    
  
    
    private ListNode carryRecursion(ListNode l1, ListNode l2, ListNode head, ListNode tailPrior){
        
        if(l1 == null && l2 == null) 
            return tailPrior;  
        ListNode l1Next = l1 != null ? l1.next : null,
                 l2Next = l2 != null ? l2.next : null;
        int result = 0, carry = 0;
        if(l1 != null)  result += l1.val;
        if(l2 != null)  result += l2.val;
        result += head.val;
        carry = result / 10;
        result = result % 10;
        head.val = result;
        head.next = new ListNode(carry);
        return carryRecursion(l1Next, l2Next, head.next, head);  
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tailPrior = carryRecursion(l1, l2, head, head); //最后一个参数为记录尾端前继，递归函数用，这里可以任意填写
        tailPrior.next = tailPrior.next.val == 0 ? null : tailPrior.next; //如果进位值为0则去掉
        return head;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(9, new ListNode(7)))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(9, new ListNode(9));
//        ListNode l2 = new ListNode(1);
        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }
    
    /**  
     * (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 
     * 一开始题目理解错了，理解成： 2，4，3 、 5， 6， 4 依次为 百位 十位 个位  8 -> 0 -> 7 输出  难度大了不少!!!
     */
    
//    private ListNode reverseList(ListNode targetNode){
//        if(targetNode.next == null){
//            return targetNode;
//        }
//        ListNode p1 = targetNode, p2 = targetNode.next, p3 = targetNode.next.next;
//        while (p2 != null) {
//            p1.next = null;
//            p2.next = p1;
//            p1 = p2;
//            p2 = p3;
//            if(p3 != null)
//                p3 = p3.next;
//        }
//        return p1;
//    }
//    
//    private ListNode carryRecursion(ListNode l1, ListNode l2){
//        
//        if(l1 == null || l2 == null) 
//            return new ListNode(0); //空值不进位
//        
//        ListNode head = null;
//        ListNode recursionNode = carryRecursion(l1.next, l2.next); //包含进位值
//        int result = (l1.val + l2.val + recursionNode.val) % 10;
//        int carry = (l1.val + l2.val + recursionNode.val) / 10;
//        head = new ListNode(carry);
//        recursionNode.val = result;
//        head.next = recursionNode;
//        return head;
//    }
//    
//    private ListNode findPrior(ListNode node, ListNode l){
//        ListNode prior = null;
//        while (node != null) {
//            prior = l;
//            l = l.next;
//            node = node.next;
//        } 
//        return prior;
//    }
//    
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode node;
//        ListNode node1 = l1;
//        ListNode node2 = l2;
//        ListNode prior = null;
//        while (node1 != null && node2 != null) {
//            node1 = node1.next;
//            node2 = node2.next;
//        }
//        prior = node1 != null ? findPrior(node1, l1) : //操作互斥， prior记录超出部分尾部，以便稍后连接
//                                findPrior(node2, l2); 
//        if(prior == null){
//            node = carryRecursion(l1, l2);
//            if(node.val == 0){
//                node = node.next;
//            }
//            return reverseList(node);
//        }
//        node = node1 != null ? carryRecursion(prior.next, l2) : //carryRecursion 两参数链表等长
//                               carryRecursion(l1, prior.next);
//        prior.val += node.val;
//        prior.next = node.next;
//        node = node1 != null ? reverseList(l1) : 
//                               reverseList(l2);
//        return node;
//    }
    
}
