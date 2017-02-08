/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        List<List<Integer>> pathset = new ArrayList<List<Integer>>();
        
        getPathSet(pathset, new ArrayList<Integer>(), root);
        
        return getSum(pathset);
        
    }
    
    public void getPathSet(List<List<Integer>> pathset, List<Integer> temp, TreeNode root) {
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            pathset.add(new ArrayList<Integer>(temp));
            // System.out.println("temp = "+toString(temp));
        }
        
        if(root.left != null) {
            getPathSet(pathset, temp, root.left);
        }
        if(root.right != null) {
            getPathSet(pathset, temp, root.right);
        }
        temp.remove(temp.size()-1);
        
    }
    
    private int getSum(List<List<Integer>> set) {
        int sum = 0;
        for(List<Integer> list : set) {
            int size = list.size();
            int num = 0;
            for(int i = 0; i<size; i++) {
                num += list.get(i)*Math.pow(10, size-i-1);
            }
            // System.out.println("num = "+num);
            sum += num;
        }
        return sum;
    }
}