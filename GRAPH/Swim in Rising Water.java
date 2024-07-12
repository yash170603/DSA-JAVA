import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] minTime = new int[n][n];
        
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        
        minTime[0][0] = grid[0][0];
        pq.add(new Cell(0, 0, grid[0][0]));
        
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int r = cell.row;
            int c = cell.col;
            int time = cell.time;
            
            if (r == n - 1 && c == n - 1) {
                return time;
            }
            
            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                
                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    int newTime = Math.max(time, grid[nr][nc]);
                    if (newTime < minTime[nr][nc]) {
                        minTime[nr][nc] = newTime;
                        pq.add(new Cell(nr, nc, newTime));
                    }
                }
            }
        }
        
        return -1; // This line should never be reached
    }
    
    class Cell {
        int row;
        int col;
        int time;
        
        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
