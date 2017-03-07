/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 17-02-04 16:14
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
           ArrayList result = new ArrayList<>();
           if (root == null) {
            return result;
        }
        // write your code here
    
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           ArrayList<Integer> level = new ArrayList<Integer>();
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               level.add(node.val);
               if (node.left != null) {
                   queue.offer(node.left);
               }
               
               if (node.right != null) {
                   queue.offer(node.right);
               }
           } 
           result.add(level);
           
       }
       return result;
    }
}