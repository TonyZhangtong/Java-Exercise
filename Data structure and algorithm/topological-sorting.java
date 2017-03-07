/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 17-02-11 23:22
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        if ( graph == null) {
            return order;
        }
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0 ) {
                queue.offer(node);
                order.add(node);
            }
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();
            for (DirectedGraphNode neighbor : head.neighbors) {
              
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0 ) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        
        return order;
        
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }
} 
/*
public class Solution {
     
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        
            return order;
        }
        
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
                order.add(node);
            }
        }
        
        while(!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0 ) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        
        return order;
       
        // write your code here
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        
        return indegree;
        
    }
}
*/