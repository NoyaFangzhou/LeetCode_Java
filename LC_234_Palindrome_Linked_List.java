/*
Given a singly linked list, determine if it is a palindrome.
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
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = head;
        ListNode pre = null;
        while(fast!=null && fast.next!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        pre.next = null;
        
        ListNode second = reverseLinkedList(mid);
        
        while(head != null && second != null) {
            if (head.val != second.val) {
                return false;
            }
            head = head.next;
            second = second.next;
        }
        
        return true;
        
        
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        
        ListNode pre = null, cur = head, next = null;
        
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
        
    }
}