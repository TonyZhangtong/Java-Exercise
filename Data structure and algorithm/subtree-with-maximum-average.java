/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Java
@Datetime: 17-01-30 22:09
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
    public class ResultType {
        public int size, sum;
        public ResultType(int sum, int size) {
            this.size = size;
            this.sum = sum;
        }
    }
    public TreeNode subtree = null;
    public ResultType subtreeResult = null;
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
        // Write your code here
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null){
            return new ResultType(0, 0);
        }
         
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        ResultType result = new ResultType(left.sum + right.sum + root.val, right.size + left.size + 1);
        
        if(subtree == null || result.sum * subtreeResult.size > result.size * subtreeResult.sum) {
            subtree = root;
            subtreeResult = result;
        } 
        
        return result;
    }
}