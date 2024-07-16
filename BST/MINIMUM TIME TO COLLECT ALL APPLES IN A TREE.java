class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Create adjacency list for the tree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Array to mark if a node is on a path to an apple
        boolean[] next = new boolean[n];
        
        // Mark nodes on the path to any apple
        dfsMark(-1, 0, adj, hasApple, next);
        
        // Calculate the minimum time required
        return dfsTime(-1, 0, adj, next);
    }

    // DFS to mark nodes on the path to any apple
    public boolean dfsMark(int parent, int index, List<List<Integer>> adj, List<Boolean> hasApple, boolean[] next) {
        boolean hasPathToApple = hasApple.get(index);
        for (int child : adj.get(index)) {
            if (child != parent) {
                if (dfsMark(index, child, adj, hasApple, next)) {
                    hasPathToApple = true;
                }
            }
        }
        next[index] = hasPathToApple;
        return hasPathToApple;
    }

    // DFS to calculate the minimum time required
    public int dfsTime(int parent, int index, List<List<Integer>> adj, boolean[] next) {
        int time = 0;
        for (int child : adj.get(index)) {
            if (child != parent && next[child]) {
                time += dfsTime(index, child, adj, next) + 2;
            }
        }
        return time;
    }

   
}
