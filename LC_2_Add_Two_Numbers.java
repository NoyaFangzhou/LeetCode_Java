/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = null;
        ListNode head = null;
        int carry = 0;
        while(l1!=null && l2!=null) {
            // System.out.println("l1.val ="+l1.val+" l2.val = "+l2.val);
            int res = l1.val+l2.val+carry;
            // System.out.println("res = "+res);
            if (result!=null) {
                // System.out.println("result.next");
                result.next = new ListNode(res%10);
                result = result.next;
            }
            else {
                // System.out.println("result");
                result = new ListNode(res%10);
                head = result;
            }
            carry = res/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            int res = l1.val+carry;
            result.next = new ListNode(res%10);
            carry = res/10;
            l1 = l1.next;
            result = result.next;
        }
        
        while(l2 != null) {
            int res = l2.val+carry;
            result.next = new ListNode(res%10);
            carry = res/10;
            l2 = l2.next;
            result = result.next;
        }
        
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        
        return head;
    }
}