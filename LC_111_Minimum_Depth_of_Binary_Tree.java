/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        iterate(path, new ArrayList<Integer>(), root);
        int min = Integer.MAX_VALUE;
        for(List<Integer> l: path) {
            int length = l.size();
            if (length < min) {
                min = length;
            }
        }
        return min;
        
        
    }
    
    private void iterate(List<List<Integer>> result, List<Integer> temp, TreeNode root) {
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            // System.out.println(toString(temp));
            result.add(new ArrayList<Integer>(temp));
        }
       
        if (root.left != null)
            iterate(result, temp, root.left);
        if (root.right != null)
            iterate(result, temp, root.right);
             
        temp.remove(temp.size()-1);
        
    }
    
    // private String toString(List<Integer> list) {
    //     StringBuilder s = new StringBuilder();
    //     for(int n: list) {
    //         s.append(n + " ");
    //     }
    //     return s.toString();
    // }

    // Solution 2 using recursive
    public int minDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth2(root.right)+1;
        }
        if (root.right == null) {
            return minDepth2(root.left)+1;
        }
        
        return Math.min(minDepth2(root.left), minDepth2(root.right))+1;
    }
}