import java.util.HashMap;
import java.util.HashSet;

class Solution {
    int n;
    int m;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int id = 2;
        int[][] vis = new int[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();

        // Perform DFS for each unvisited cell to mark the islands and count their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 1 && grid[i][j] == 1) {
                    int count = dfs(i, j, id, vis, grid);
                    map.put(id, count);
                    id++;
                }
            }
        }

        // Find the largest island
        int ans = 0;
        for (int size : map.values()) {
            ans = Math.max(ans, size);
        }

        // Check each zero cell and calculate the potential largest island size
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (grid[a][b] == 0) {
                    HashSet<Integer> seen = new HashSet<>();
                    int newSize = 1;

                    // Check all 4 neighbors
                    for (int[] dir : new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }) {
                        int x = a + dir[0], y = b + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > 1) {
                            int islandId = grid[x][y];
                            if (!seen.contains(islandId)) {
                                seen.add(islandId);
                                newSize += map.get(islandId);
                            }
                        }
                    }
                    ans = Math.max(ans, newSize);
                }
            }
        }

        return ans;
    }

    public int dfs(int i, int j, int id, int[][] vis, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] == 1 || grid[i][j] == 0)
            return 0;

        vis[i][j] = 1;
        grid[i][j] = id;
        int count = 1;

        count += dfs(i + 1, j, id, vis, grid);
        count += dfs(i - 1, j, id, vis, grid);
        count += dfs(i, j + 1, id, vis, grid);
        count += dfs(i, j - 1, id, vis, grid);

        return count;
    }
}
