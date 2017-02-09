/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (m >= n || head == null) {
            return head;
        }
        ListNode start = head;
        ListNode pre = null;
        ListNode nodem = head;
        ListNode noden = head;
        ListNode post = null;
        int search = 2;
        while (search <= n && start != null) {
            if (search <= m) {
                // assign node to nodem
                pre = start;
                nodem = start.next;
            }
            else {
                // assign node to noden
                noden = start.next;
                post = noden.next;
            }
            start = start.next;
            search ++;
        }
        
        // break the linklist from pre to noden
        if (pre != null) {
            pre.next = null;
        }
        if (noden != null) {
            noden.next = null;
        }
        
        
        // reverse the node from noden to nodem
        reverse(nodem, noden);
        if (pre != null) {
            pre.next = noden;
        }
        nodem.next = post;
        
        return m == 1? noden : head;
        
    }
    
    // pass the ListNode(m) and the stop position ListNode(n)
    // return the begin node after reverse
    public void reverse(ListNode head, ListNode stop) {
        ListNode pre = null, curr = head, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            if (curr.equals(stop)) {
                break;
            }
            pre = curr;
            curr = next;
        }
        
    }

    // Simpler Solution
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (m >= n || head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        
        
        ListNode target_head = new ListNode(0);
        ListNode target_tail = head;
        int search = 1;
        
        while(search <= n) {
            ListNode next = cur.next;
            // move the cur to the node m
            if (search < m) {
                pre = cur;
            }
            // mark the cur to the target_tail, the tail of the reversed linked list
            // link the cur after the target_head, for convenience to do the reverse
            else if (search == m) {
                target_tail = cur;
                target_head.next = cur;
            }
            // reverse the node within the region, target_head alwasy link to the tail node after reverse between two node
            // cur.next= target_head.next do the reverse
            else {
                cur.next = target_head.next;
                target_head.next = cur;
            }
            
            search += 1;
            cur = next;
        }
        
        if (pre != null) {
            pre.next = target_head.next; // connect the pre to the head of the reverse linked list
        }
        target_tail.next = cur; // connect the tail to the node after n
        
        return m == 1? target_head.next: head;

        
    }
}