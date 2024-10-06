import java.util.*;

class Solution {
    HashMap<Integer, HashSet<Integer>> map;

    public List<Integer> remainingMethods(int n, int k, int[][] edges) {
        map = new HashMap<>();
        
        // Initialize adjacency list for all nodes
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        
        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        
        Set<Integer> aft = new HashSet<>();
        dfs(k, aft);
        
        List<Integer> naft = new ArrayList<>();
        Set<Integer> naftSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!aft.contains(i)) {
                naft.add(i);
                naftSet.add(i);
            }
        }
        
        // Check for edges between naft and aft
        for (int okay : naftSet) {
            if (hasEdgeToAft(okay, aft)) {
                naft.addAll(aft);
                break;
            }
        }
        
        return naft;
    }
    
    private boolean hasEdgeToAft(int node, Set<Integer> aft) {
        for (int neighbor : map.get(node)) {
            if (aft.contains(neighbor)) {
                return true;
            }
        }
        return false;
    }
    
    private void dfs(int node, Set<Integer> aft) {
        if (!aft.add(node)) return; // If node was already in aft, return
        for (int neigh : map.get(node)) {
            dfs(neigh, aft);
        }
    }
}
