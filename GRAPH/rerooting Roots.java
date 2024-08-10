import java.util.*;

class Solution {
    public void dfs(int root, int prev, int[] ans, List<List<Integer>> adj, int[][] dp) {
        int curr;
        for (int j : adj.get(root)) {
            if (j != prev) {
                dfs(j, root, ans, adj, dp); // check max for child

                curr = dp[j][0] + (j % 2 == 1 ? 1 : 2); // add for child value

                if (curr > dp[root][0]) { // set maximum
                    dp[root][1] = dp[root][0];
                    dp[root][0] = curr;
                } else if (curr > dp[root][1]) {
                    dp[root][1] = curr;
                }
            }
        }
    }

    public void findMax(int root, int prev, int incoming, int[] ans, List<List<Integer>> adj, int[][] dp) {
        ans[root] = Math.max(dp[root][0], incoming); // max for root

        int pa = (root % 2 == 1 ? 1 : 2);

        int curr, x;

        for (int j : adj.get(root)) {
            if (j != prev) {
                curr = dp[j][0] + (j % 2 == 1 ? 1 : 2); // curr value

                if (curr == dp[root][0]) {
                    x = dp[root][1]; // other
                } else {
                    x = dp[root][0];
                }

                findMax(j, root, Math.max(pa + incoming, pa + x), ans, adj, dp); // check for adjacent
            }
        }
    }

    public int[] timeTaken(int[][] edges) {
        int n = edges.length + 1;
        int[] ans = new int[n];
        int[][] dp = new int[n][2];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build adj list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // find max of both childs
        dfs(0, -1, ans, adj, dp);

        // find max of child and parent
        findMax(0, -1, 0, ans, adj, dp);

        return ans;
    }
}
