/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelIterator(root, result, 0);
        return result;
        
    }
    // use backtrack
    // height here used to indicate the level
    private void levelIterator(TreeNode root, List<List<Integer>> result, int height) {
        if (root == null) {
            return;
        }
        if (height >= result.size()) {
            // create the new list for new level
            result.add(new ArrayList<Integer>());
        }
        // first find its level by get(height) and then add the value into the specific level array
        result.get(height).add(root.val);
        levelIterator(root.left, result, height+1);
        levelIterator(root.right, result, height+1);
        
    }
}