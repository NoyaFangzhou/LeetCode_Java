/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        int length = 1;
        ListNode cur = head; 
        while (cur!= null) {
            length ++;
            cur = cur.next;
        }
        if (length <= 2) {
            return;
        }
        // find the middle point
        ListNode slow = head;
        ListNode fast = head;
        ListNode preMid = head;
        // suppose we have a chain 1->2->3->4->5->6->7
        // after this while-loop, we got:
        // mid = node(4), preMid = node(3), postMid = node(5)
        // 1->2->3->4->5->6->7
        while (fast != null && fast.next != null) {
            preMid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode postMid = slow.next;
        
        // separate the LinkList by the middle
        // 1->2->3->4     5->6->7
        mid.next = null; 
       
        // then we reverse the chain after mid point
        //1->2->3->4     7->6->5
        postMid = reverse(postMid);
        
        
        // then we merge two chains one by one and then we can get the desired result
        // 1->7->2->6->3->5->4
        merge(head, postMid);
    }
    
    private ListNode reverse(ListNode head) {
        // curr: current node
        // prev: previous node, should be the node next to the current node after reverse
        // next: the next node to be manipulated, it should be the next node of the current node before reverse
        // 1->2->3
        // curr = 1, prev = null, next = 2;
        // after reverse curr and prev, we need to manipulate NEXT
        // according to the def before, we should assign next = curr.next, prev = curr, curr = next 
        ListNode prev = null, curr = head, next = null;
      
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
      
        return prev;
    }
    
    private void merge(ListNode n1, ListNode n2) {
        while(n1 != null && n2 != null) {
            ListNode temp1 = n1.next;
            ListNode temp2 = n2.next;
            n1.next = n2;
            n2.next = temp1;
            n1 = temp1;
            n2 = temp2;
        }
    }
}