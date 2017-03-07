/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/search-graph-nodes
@Language: Java
@Datetime: 17-02-11 22:29
*/

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        Queue <UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (target == values.get(head)) {
                        return head;}
            for(UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    
                    
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return null;
    }
            
}