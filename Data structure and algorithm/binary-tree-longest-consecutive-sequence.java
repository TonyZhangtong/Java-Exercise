/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence
@Language: Java
@Datetime: 17-02-01 20:01
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
    private int longest;
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        helper(root);
        return longest;
        // Write your code here
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int subtreeLongest = 1;
        if(root.left !=null && root.val + 1 == root.left.val) {
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }
        
        if(root.right != null && root.val + 1 == root.right.val) {
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }
        
        if (subtreeLongest > longest) {
            longest = subtreeLongest;
        }
        
        return subtreeLongest;
        
    }
}