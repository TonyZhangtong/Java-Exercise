/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor
@Language: Java
@Datetime: 17-01-31 21:51
*/

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        
        
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left != null && right != null) {
            return root;
        }
        
        if(left != null) {
            return left;
        }
        
        if(right != null) {
            return right;
        }
        
        return null;
    } 
}