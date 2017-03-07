/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-02-01 21:22
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } 
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root,path,root.val,target,result);
        return result;
    }
    
    private void helper(TreeNode root, ArrayList<Integer> path, int sum,int target, List<List<Integer>> result) {
        if(root.left == null &&root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
        }
        
        if(root.left!= null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result );
            path.remove(path.size() - 1);
        }
        
        if(root.right!= null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result );
            path.remove(path.size() - 1);
        }
    }
}

