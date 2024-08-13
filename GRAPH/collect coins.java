import java.util.*;

public class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Set<Integer>> g = new ArrayList<>(n);
        
        // Initialize the adjacency list for each node
        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
        }

        // Build the graph by adding edges between nodes
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        int totalEdges = edges.length * 2; // Each edge is counted twice (for both directions)
        int deleted = 0;

        // Add leaves with no coins to the queue
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1 && coins[i] == 0) {
                leaves.add(i);
            }
        }

        // Remove leaves with no coins and their associated edges
        while (!leaves.isEmpty()) {
            int leaf = leaves.poll();
            
            // Skip if the leaf has no connected edges
            if (g.get(leaf).isEmpty()) {
                continue;
            }

            int parent = g.get(leaf).iterator().next(); // Get the parent of the leaf
            g.get(parent).remove(leaf); // Remove the leaf from the parent's set
            deleted++;
            g.get(leaf).remove(parent); // Remove the parent from the leaf's set
            deleted++;

            // If the parent becomes a leaf with no coins, add it to the queue
            if (g.get(parent).size() == 1 && coins[parent] == 0) {
                leaves.add(parent);
            }
        }

        // Now, the remaining leaves should all have coins
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1) {
                leaves.add(i); // Add leaves to the queue again for further processing
            }
        }

        int step = 2; // Two steps: one for removing leaves and another for their immediate parents
        while (step-- > 0) {
            int sz = leaves.size();
            while (sz-- > 0) {
                int leaf = leaves.poll();
                
                // Skip if the leaf has no connected edges
                if (g.get(leaf).isEmpty()) {
                    continue;
                }

                int parent = g.get(leaf).iterator().next(); // Get the parent of the leaf
                g.get(parent).remove(leaf); // Remove the leaf from the parent's set
                deleted++;
                g.get(leaf).remove(parent); // Remove the parent from the leaf's set
                deleted++;

                // If the parent becomes a leaf after removal, add it to the queue
                if (g.get(parent).size() == 1) {
                    leaves.add(parent);
                }
            }
        }

        // Return the remaining number of edges after deletion
        return totalEdges - deleted;
    }
}
