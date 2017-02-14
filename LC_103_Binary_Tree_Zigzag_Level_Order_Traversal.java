/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return result;
        }
        
        zigzagIterator(root, result, 0);
        
        for(int l = 0; l<result.size(); l++) {
            if (l%2 == 1) {
                Collections.reverse(result.get(l));
            }
        }
        return result;
        
    }
    
    private void zigzagIterator(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        
        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        
        result.get(level).add(root.val);
        
        zigzagIterator(root.left, result, level+1);
        zigzagIterator(root.right, result, level+1);
    }
}