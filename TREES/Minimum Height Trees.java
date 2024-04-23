import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int N, int[][] edges) {
        if (N == 1) {
            return Collections.singletonList(0); // Special case: only one node
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>()); 
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        int remainingNodes = N;
        while (remainingNodes > 2) {
            int leavesSize = leaves.size();
            remainingNodes -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                //int neighbor = adj.get(leaf).iterator().next(); // Get the only neighbor of the leaf
                 int neighbor = adj.get(leaf).get(0) ; 
               // adj.get(neighbor).remove(leaf); // Remove the leaf from its neighbor's adjacency list
                adj.get(neighbor).remove((Integer) leaf);
                if (adj.get(neighbor).size() == 1) {
                    leaves.offer(neighbor);
                }
            }
        }
        
        return new ArrayList<>(leaves);
    }
} // leaf will always make a length tree, so keep removing the leafs and you reach either 2 or 1 node left in tree/graph, watch aryans video
