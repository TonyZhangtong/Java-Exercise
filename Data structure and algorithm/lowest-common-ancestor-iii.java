/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 17-02-01 02:58
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
class ResultType{
    public TreeNode result;
    public boolean existA;
    public boolean existB;
    public ResultType(TreeNode result, boolean existA, boolean existB) {
        this.result = result;
        this.existA = existA;
        this.existB = existB;
    }
} 

public class Solution {

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        
        ResultType results = helper(root, A, B);
        if(results.existA && results.existB) {
            return results.result;
        }
        return null;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        
        if (root == null) {
           
            return new ResultType(null, false, false);
        }
        
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean a_exist = left.existA || right.existA || root == A;
        boolean b_exist = right.existB || left.existB || root == B;
        
          if (root == A || root == B) {
            return new ResultType(root, a_exist, b_exist);
        }
        
     
        if(left.result != null && right.result != null) {
            //if((left.existA || left.existB) && (right.existA || right.existB  ))
            return new ResultType (root, a_exist, b_exist);
        }
        
        if(left.result != null) {
            return new ResultType(left.result, a_exist, b_exist);
        }
        
        if(right.result != null) {
            return new ResultType(right.result, a_exist, b_exist);
        }
        
        return new ResultType(null, a_exist, b_exist);
    }
}