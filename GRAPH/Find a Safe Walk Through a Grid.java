class Solution {
    boolean[][] vis;
    int[][][] dp;
    boolean check(List<List<Integer>> grid, int row, int col, int hlt) {
        int m = grid.size(); int n = grid.get(0).size();
        if (row >= m || col >= n || row<0 || col<0 || hlt<=0 || vis[row][col]) return false;
        if (row==m-1 && col==n-1) {
            return hlt>grid.get(row).get(col);
        }
        if (dp[row][col][hlt]!=-1) return dp[row][col][hlt]==1;
        vis[row][col] = true;
        boolean up = check(grid,row-1,col,hlt-grid.get(row).get(col));
        boolean dw = check(grid,row+1,col,hlt-grid.get(row).get(col));
        boolean lf = check(grid,row,col-1,hlt-grid.get(row).get(col));
        boolean rf = check(grid,row,col+1,hlt-grid.get(row).get(col));
        vis[row][col] = false;
        boolean result = up || dw || lf || rf;
        if(result){
            dp[row][col][hlt]=1;
        }
        else dp[row][col][hlt]=0;
        return result;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        dp = new int[m][n][health+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        vis = new boolean[m][n];
        return check(grid, 0, 0, health);
    }
}
/////




import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][][] visited = new boolean[m][n][health + 1];
        Queue<int[]> queue = new LinkedList<>();

        // Start BFS from (0, 0) with initial health
        queue.offer(new int[]{0, 0, grid.get(0).get(0) == 1 ? health - 1 : health});
        visited[0][0][health] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int h = curr[2];

            // Check if we reached the end cell
            if (x == m - 1 && y == n - 1 && h > 0) {
                return true;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int nh = grid.get(nx).get(ny) == 1 ? h - 1 : h;
                    if (nh > 0 && !visited[nx][ny][nh]) {
                        visited[nx][ny][nh] = true;
                        queue.offer(new int[]{nx, ny, nh});
                    }
                }
            }
        }

        return false;
    }
}
