import java.util.*;

class Solution {
    
    // Function to return the shortest path between src and dest using BFS
    public int[] getPath(int src, int dest, List<List<Integer>> adj) {
        int n = adj.size();
        int[] dis = new int[n]; // Distance array
        int[] parent = new int[n]; // Parent array to track path
        Arrays.fill(dis, -1);
        Arrays.fill(parent, -1);
        dis[src] = 0; // Source node has distance 0

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        // Perform BFS to find the shortest path from src to dest
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dis[v] == -1) { // If the node v hasn't been visited
                    dis[v] = dis[u] + 1; // Update distance
                    parent[v] = u; // Track parent node
                    q.offer(v); // Continue BFS
                }
            }
        }

        // Trace the path from dest to src using the parent array
        List<Integer> path = new ArrayList<>();
        for (int node = dest; node != -1; node = parent[node]) {
            path.add(node);
        }
        Collections.reverse(path); // Reverse to get the correct order

        // Convert List<Integer> to int[]
        return path.stream().mapToInt(Integer::intValue).toArray();
    }

    // Handle 1D case: Find the start and end if their degrees are 1
    public int[][] handle1D(List<List<Integer>> adj) {
        int dest = -1, src = -1;
        int n = adj.size();
        
        // Find the endpoints (degree == 1)
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() > 1) continue;
            if (src == -1) src = i;
            else if (dest == -1) dest = i;
        }

        // If no valid path, return empty matrix
        if (dest == -1) return new int[0][];
        
        // Get the path between src and dest
        int[] path = getPath(src, dest, adj);
        int[][] result = new int[1][path.length];
        
        // Fill the first row with the path
        for (int i = 0; i < path.length; i++) {
            result[0][i] = path[i];
        }
        return result;
    }

    // Main function to construct the grid layout
    public int[][] constructGridLayout(int n, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Handle the 1D case
        int[][] ans = handle1D(adj);
        if (ans.length > 0) return ans;

        // Step 3: Identify corners (nodes with degree 2)
        List<Integer> corners = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 2) {
                corners.add(i);
            }
        }

        // Step 4: Find the smallest path out of three possible corner pairs
        int col = Integer.MAX_VALUE; // Track the smallest path length
        int smallestIndex = -1; // Track which path is the smallest

        int[] path1 = getPath(corners.get(0), corners.get(1), adj);
        if (path1.length < col) {
            col = path1.length;
            smallestIndex = 0; // path1 is currently the smallest
        }

        int[] path2 = getPath(corners.get(0), corners.get(2), adj);
        if (path2.length < col) {
            col = path2.length;
            smallestIndex = 1; // path2 is currently the smallest
        }

        int[] path3 = getPath(corners.get(0), corners.get(3), adj);
        if (path3.length < col) {
            col = path3.length;
            smallestIndex = 2; // path3 is currently the smallest
        }

        // Step 5: Calculate the dimensions of the matrix
        int rows = n / col;
        int[][] result = new int[rows][col];

        // Get the smallest path to fill the first row
        int[] smallestPath = (smallestIndex == 0) ? path1 : (smallestIndex == 1) ? path2 : path3;
        
        for (int i = 0; i < col; i++) {
            result[0][i] = smallestPath[i];
        }

        // Step 6: Fill the remaining rows by expanding neighbors
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < col; c++) {
                Set<Integer> neighbors = new HashSet<>();
                if (r > 0) neighbors.add(result[r - 1][c]); // Above neighbor
                if (c > 0) neighbors.add(result[r][c - 1]); // Left neighbor
                if (c + 1 < col) neighbors.add(result[r][c + 1]); // Right neighbor
                
                int u = result[r][c];
                for (int v : adj.get(u)) {
                    if (!neighbors.contains(v)) {
                        result[r + 1][c] = v; // Fill the next row
                        break;
                    }
                }
            }
        }

        return result; // Final grid layout
    }
}
