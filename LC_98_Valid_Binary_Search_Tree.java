/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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
    public boolean isValidBST(TreeNode root) {
        boolean result = false;
        // null tree
        if (root == null) {
            return true;
        }
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean validBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (min >= max) {
            return false;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }
}