/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        sum(result, new ArrayList<Integer>(), root, sum);
        return result;
    }
    
    public void sum(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
        // System.out.println("temp = "+toString(temp));
        if (root == null) {
            // temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        //match and is leaf
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                 //add the path to the result
                result.add(new ArrayList<Integer>(temp));
            }
            // return;
        }
        sum(result, temp, root.left, sum-root.val);
        
        sum(result, temp, root.right, sum-root.val);
        
        temp.remove(temp.size()-1);
        
    }
    
    private String toString(List<Integer> temp) {
        String s = "";
        for(int n : temp) {
            s += n+ " ";
        }
        return s;
    }
}