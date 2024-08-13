import java.util.ArrayList;
import java.util.List;

class Solution {
    public int count;
    List<List<Integer>> adj;
    
    public int countGoodNodes(int[][] edges) {
        count = 0;
        int n = edges.length + 1; // Number of nodes is edges.length + 1
        adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
      
        
        // Build the undirected tree
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Start DFS from root node 0, with -1 as its parent (indicating no parent)
        dfs(0, -1);
        return count;
    }
    
    public int dfs(int node, int parent) {
        int subtreeSize = 1; // Start with 1 to include the current node itself
        int firstChildSize = -1; // Initialize to an invalid value
        boolean isGoodNode = true;
        
        for (int child : adj.get(node)) {
            if (child != parent) { // Avoid revisiting the parent node
                int childSubtreeSize = dfs(child, node);
                if (firstChildSize == -1) {
                    firstChildSize = childSubtreeSize;
                } else if (firstChildSize != childSubtreeSize) {
                    isGoodNode = false;
                }
                subtreeSize += childSubtreeSize;
            }
        }
        
        if (isGoodNode) {
            count++;
        }
        
        return subtreeSize;
    }
}



bruteforce


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int count;
    List<List<Integer>> adj;
    
    public int countGoodNodes(int[][] edges) {
        count = 0;
        int n = edges.length + 1; // Number of nodes is edges.length + 1
        adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the undirected tree
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Start DFS from root node 0, with -1 as its parent (indicating no parent)
        dfs(0, -1);
        return count;
    }
    
    public int dfs(int node, int parent) {
        int subtreeSize = 1; // Start with 1 to include the current node itself
        int firstChildSize = -1; // Initialize to an invalid value
        boolean isGoodNode = true;
        
        for (int child : adj.get(node)) {
            if (child != parent) { // Avoid revisiting the parent node
                int childSubtreeSize = dfs(child, node);
                if (firstChildSize == -1) {
                    firstChildSize = childSubtreeSize;
                } else if (firstChildSize != childSubtreeSize) {
                    isGoodNode = false;
                }
                subtreeSize += childSubtreeSize;
            }
        }
        
        if (isGoodNode) {
            count++;
        }
        
        return subtreeSize;
    }
}
