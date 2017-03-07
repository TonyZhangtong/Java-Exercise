/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 17-02-09 03:22
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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        Queue  <TreeNode> queue = new LinkedList<TreeNode>();
        
  
    
        queue.offer(root);
        int size = queue.size();
        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++ ) {
                TreeNode node = queue.poll();
                level.add(node.val);
        
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                queue.offer(node.right);
                }
            }
        size = queue.size();
        result.add(level);   
        }
       Collections.reverse(result);
        
  
        return result;  
    
    }
}