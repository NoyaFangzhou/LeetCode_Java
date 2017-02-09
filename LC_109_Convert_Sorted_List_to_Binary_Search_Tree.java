/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        return ListToBST(head, null);
        
    }

    public TreeNode ListToBST(ListNode head, ListNode tail) {
       
       ListNode slow = head;
       ListNode fast = head;
       if (head == tail) {
           return null;
       }
       
       // find the mid point
       while(fast.next != tail && fast.next.next != tail) {
           fast = fast.next.next;
           slow = slow.next;
       }
        
        // build the root
        TreeNode root = new TreeNode(slow.val);
        
        root.left = ListToBST(head, slow);
        root.right = ListToBST(slow.next, tail);
        
        return root;
    }
    
}