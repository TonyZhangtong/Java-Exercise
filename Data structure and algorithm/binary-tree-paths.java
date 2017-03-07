/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-01-30 20:18
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
    
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> paths = new ArrayList<String>();
       
       if (root == null) {
           return paths;
       }
       
       if (root.left == null && root.right == null) {
           paths.add(root.val + "");
           return paths;
       }
       
       List<String> leftpaths = binaryTreePaths(root.left);
       List<String> rightpaths = binaryTreePaths(root.right);
       
       for (String path : leftpaths) {
          paths.add(root.val + "->" + path);
       }
       for (String path : rightpaths) {
           paths.add(root.val + "->" + path);
       }
       return paths;
    }
 }
 
 /**
  * 
  * 
  * 
public class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
     List<String> result = new ArrayList<String>();
     if (root == null) {
         return result;
     }
     
     helper(root, String.valueOf(root.val), result);
     return result;
    }
    
    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        if(root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}
*/