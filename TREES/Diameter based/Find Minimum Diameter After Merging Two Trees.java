public class Solution {

    // Function to build the adjacency list for a tree
    public Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for both trees
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);

        // Calculate the diameters of both trees
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        // Calculate the longest path that spans across both trees
        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(d1, d2), combined);
    }

    // Function to find the diameter of a tree using two DFS calls
    public int findDiameter(Map<Integer, List<Integer>> adjList) {
        // First DFS to find the farthest node from any arbitrary node (e.g., 0)
        int[] farthest = DFS(adjList, 0, -1);

        // Second DFS from the farthest node to determine the diameter
        farthest = DFS(adjList, farthest[0], -1);
        return farthest[1];
    }

    // DFS helper function to find the farthest node and its distance from the source
    public int[] DFS(Map<Integer, List<Integer>> adjList, int node, int parent) {
        int farthestNode = node;
        int maxDistance = 0;

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (neighbor != parent) { // Avoid revisiting the parent
                int[] result = DFS(adjList, neighbor, node);
                int distance = result[1] + 1;
                if (distance > maxDistance) {
                    maxDistance = distance;
                    farthestNode = result[0];
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}
