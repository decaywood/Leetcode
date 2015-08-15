package easy;

import dataStructure.ListNode;

/**
 * @author decaywood
 * 
 * 2015年1月4日
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 */
public class IntersectionOfTwoLinkedLists {
    

    

    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null ||headB == null)return null;  
        ListNode h1 = headA;  
        ListNode h2 = headB;  
        int count1 = 1, count2 = 1;  
        while(h1.next != null){  
            count1++;  
            h1 = h1.next;  
        }  
        while(h2.next != null){  
            count2++;  
            h2 = h2.next;  
        }  
        if(h1 != h2) return null;  
        else{  
            int count = Math.abs(count1 - count2);  
            if(count2 > count1){  
                h1 = headB;  
                h2 = headA;   
            }  
            else{  
                h1 = headA;  
                h2 = headB;  
            }  
            while((count--) > 0){  
                h1 = h1.next;  
            }  
            while(h1 != null&&h2 != null && h1 != h2){  
                h1 = h1.next;  
                h2 = h2.next;  
            }  
            return h1;  
        }  
    }  
    
     
}
