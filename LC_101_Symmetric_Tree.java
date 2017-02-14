/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        // empty tree
        if (root == null) {
            return true;
        }
        
        // tree with only one node
        if (root.left == null && root.right == null) {
            return true;
        }
        
        
        return isSymmetricTree(root.left, root.right);
        
    }
    
    private boolean isSymmetricTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2; // only true when t1 == null and t2 == null
        }
        
        if (t1.val != t2.val) {
            return false;
        }
        
        return isSymmetricTree(t1.left, t2.right) && isSymmetricTree(t1.right, t2.left);
        
    }
}