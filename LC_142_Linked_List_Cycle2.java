/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
    	// use extra space solution

        // List<ListNode> temp = new ArrayList<ListNode>();
        
        // while (head != null) {
        //     if (temp.contains(head)) {
        //         return head;
        //     }
        //     temp.add(head);
        //     head = head.next;
        // }
        
        // return null;

        // use constant space solution

        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)) {
                isCycle = true;
                break;
            }
        }
        
        if (!isCycle) {
            return null;
        }
        
        ListNode start = head;
        while (!start.equals(slow)) {
            start = start.next;
            slow = slow.next;
        }
        return start;
         
    }
}



// Explain for constant space solution:

// Suppse that we use in total k steps to find the common point, the total length of cycle is r, the distance from begin to the cycle begin point is s, // the distance from cycle begin point to common point is m.

// We can list the following equations:
// 2k - k = nr, here n is a constant number (thus fast node pass 2 node each, slow node pass 1 node each, so their difference is the total length of r)
// k = s + m

// then we can use those equations to find out our answer:
// k = nr = s + m => s = nr - m
// s = nr - r + r - m
// s = (n-1)r + (r-m)
// 
// let n == 1, we can see that 
// s = r - m, this means that the distance between start point to the cycle begin point is equal to that between the common point to the cycle begin point.
// we can iterate from start and slow and return slow or start node when they equal.



