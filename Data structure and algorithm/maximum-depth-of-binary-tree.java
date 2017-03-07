/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/maximum-depth-of-binary-tree
@Language: Java
@Datetime: 17-02-09 20:27
*/



public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        int result = Math.max(left, right) + 1;
        return result;
    }
}