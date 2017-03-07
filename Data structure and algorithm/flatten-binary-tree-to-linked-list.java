/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-01-31 19:38
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
        // write your code here
    }
    
    private TreeNode helper(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if(left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (right != null) {
            return right;
        }
        
        if (left != null) {
            return left;
        }
        
        return root;
    }
}