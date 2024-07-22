import java.util.*;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        
        // Build adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            adj.get(from).add(to);
            inDegree[to]++;
        }
        
        // Find vertices with zero in-degree
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }
        
        return result;
    }
}

