/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<String> list = new ArrayList<String>();
    //     if (root == null) {
    //         return list;
    //     }
    //     getPath(list, new ArrayList<Integer>(), root);
    //     return list;
    // }
    
    // public void getPath(List<String> path, List<Integer> temp, TreeNode root) {
    //     temp.add(root.val);
    //     if (root.left == null && root.right == null) {
    //         path.add(toString(temp));
    //     }
        
    //     if (root.left != null) {
    //         getPath(path, temp, root.left);
    //     }
    //     if (root.right != null) {
    //         getPath(path, temp, root.right);
    //     }
    //     temp.remove(temp.size()-1);
        
    // }
    
    // private String toString(List<Integer> list) {
    //     String s = "";
    //     for(int i=0; i<list.size(); i++) {
    //         if (i == list.size()-1) {
    //             s += list.get(i);
    //         }
    //         else {  
    //             s += list.get(i)+"->";
    //         }
    //     }
    //     return s;
    // }

     public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) {
            return list;
        }
        getPath(list, "", root);
        return list;
    }
    
    public void getPath(List<String> path, String p, TreeNode root) {
        if (root.left == null && root.right == null) {
            path.add(p+root.val);
        }
        
        if (root.left != null) {
            getPath(path, p+root.val+"->", root.left);
        }
        if (root.right != null) {
            getPath(path, p+root.val+"->", root.right);
        }
        
    }
    
}