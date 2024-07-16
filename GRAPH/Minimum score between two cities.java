import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // Create adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int c = road[2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, c});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, c});
        }

        // Min-heap to keep track of the minimum score edge weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, Integer.MAX_VALUE});
        boolean[] visited = new boolean[n + 1];
        int minScore = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentMinEdge = current[1];

            if (visited[u]) continue;
            visited[u] = true;
            minScore = Math.min(minScore, currentMinEdge);

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!visited[v]) {
                    pq.add(new int[]{v, edgeWeight});
                }
            }
        }

        return minScore;
    }

     
}
