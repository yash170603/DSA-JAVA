import java.util.*;

class Solution {
    private static final int LARGE_VALUE = (int) 1e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long currDis = solve(n, edges, source, destination);
        if (currDis < target) {
            return new int[0][];
        }

        boolean matchedTarget = (currDis == target);

        // Iterate through each edge with -1 weight
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = matchedTarget ? LARGE_VALUE : 1; // Assign the smallest possible value if no match

                if (!matchedTarget) {
                    long newShortestDist = solve(n, edges, source, destination);

                    if (newShortestDist <= target) {
                        matchedTarget = true;
                        edge[2] += (target - newShortestDist);  // Adjust weight to match target distance
                    }
                }
            }
        }

        if (!matchedTarget) {
            return new int[0][];
        }
        return edges;
    }

    public long solve(int n, int[][] edges, int source, int dest) {
        // Initialize adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
                adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
            }
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.distance));
        long[] res = new long[n];
        int[] vis = new int[n];

        Arrays.fill(res, Long.MAX_VALUE);
        res[source] = 0;

        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair polled = pq.poll();
            int node = (int) polled.node;
            long dist = polled.distance;

            if (vis[node] == 1) continue;
            vis[node] = 1;

            for (Pair child : adj.get(node)) {
                int neigh = (int) child.node;
                long newDis = child.distance;

                if (dist + newDis < res[neigh]) {
                    res[neigh] = dist + newDis;
                    pq.offer(new Pair(neigh, dist + newDis));
                }
            }
        }
        return res[dest];
    }
}

// Helper class to store nodes and distances
class Pair {
    long node, distance;

    Pair(long node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}
