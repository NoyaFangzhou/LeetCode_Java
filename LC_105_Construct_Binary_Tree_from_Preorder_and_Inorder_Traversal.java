/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int p_len = preorder.length;
        int i_len = inorder.length;
        
        if(p_len == 0 || i_len == 0 || p_len != i_len) {
            return null;
        }
        
        //first element in preorder is the root in inorder
        return builder(preorder, inorder, 0, p_len-1, 0, i_len-1);
    
        
    }
    
    private TreeNode builder(int[] preorder, int[] inorder, int pres, int pree, int ins, int ine) {
        
        if(pres > pree || ins > ine) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pres]); //root 
        
        // leaf node
        if (pres == pree || ins == ine) {
            return root;
        }
        
        // find the root index in the inorder array
        int ir = 0;
        for(int i = ins; i<=ine; i++) {
            if(inorder[i] == preorder[pres]) {
                ir = i;
                break;
            }
        }
        
        root.left = builder(preorder, inorder, pres+1, pres+(ir-ins), ins, ir-1);
        root.right = builder(preorder, inorder, pres+(ir-ins)+1,pree, ir+1, ine);
        return root;
        
    }
}