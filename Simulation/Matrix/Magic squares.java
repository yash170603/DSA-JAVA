import java.util.HashSet;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int row, int col) {
        HashSet<Integer> x = new HashSet<>();
        
        // Check numbers 1-9
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || x.contains(grid[i][j])) {
                    return false;
                }
                x.add(grid[i][j]);
            }
        }

        // Calculate sums
        int sum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int sum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int sum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        int sum4 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int sum5 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int sum6 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

        int sum7 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum8 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

        return sum1 == sum2 && sum2 == sum3 && sum3 == sum4 &&
               sum4 == sum5 && sum5 == sum6 && sum6 == sum7 &&
               sum7 == sum8;
    }
}
