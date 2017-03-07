/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii
@Language: Java
@Datetime: 17-02-01 21:06
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
class ResultType {
    public int longest;
    public int increase;
    public int decrease;
    
    ResultType(int longest, int increase, int decrease) {
        this.longest = longest;
        this.increase = increase;
        this.decrease = decrease;
    }
} 
 
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        
        return helper(root).longest;
        // Write your code here
    }
    
    private ResultType helper(TreeNode root) {
        
        if(root == null) {
            return new ResultType(0,0,0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int up = 0, down = 0;
        
        if(root.left != null && root.left.val  == root.val + 1) {
            up = Math.max(up, left.increase + 1); 
        }
        
        if(root.left != null && root.left.val + 1== root.val ) {
             down = Math.max(down, left.decrease + 1);
        }
        if(root.right != null && root.right.val == root.val + 1) {
            up = Math.max(up, right.increase + 1); 
        }
       
        if(root.right != null && root.right.val + 1== root.val ) {
            down = Math.max(down, right.decrease + 1);
        }
        
        int len = up + down + 1;
        len = Math.max(len, Math.max(left.longest , right.longest));
        return new ResultType(len, up, down);
    }
}