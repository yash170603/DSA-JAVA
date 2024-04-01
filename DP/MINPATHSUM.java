class Solution {
    public int minPathSum(int[][] grid) {
          int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        
        // Initialize the DP matrix with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        // Call the helper function starting from the top-left cell
        return minSumPathUtil(0, 0, grid, dp);
    }

     public int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Base cases
        if (i == n - 1 && j == m - 1)
            return matrix[n - 1][m - 1]; // If we're at the bottom-right cell, return its value
        if (i >= n || j >= m)
            return (int) Math.pow(10, 9); // If we're out of bounds, return a large value
        if (dp[i][j] != -1)
            return dp[i][j]; // If we've already calculated this cell, return the stored result

        // Calculate the sum of the current cell plus the minimum sum path from below and from the right
        int down = matrix[i][j] + minSumPathUtil(i + 1, j, matrix, dp);
        int right = matrix[i][j] + minSumPathUtil(i, j + 1, matrix, dp);

        // Store the minimum of the two possible paths
        return dp[i][j] = Math.min(down, right);
    }
}

// read till end
//Correctness: Returning 0 assumes that there is a valid path from that point onwards with a cost of 0. However, this assumption might not be true. By returning 0, you're effectively treating an out-of-bounds index as if it were a valid cell with a cost of 0, which could lead to incorrect results in the final answer.

//Path Cost Calculation: When calculating the cost of the current cell, adding 0 to the cost of reaching an out-of-bounds cell (which is essentially what returning 0 does) might not reflect the correct path cost. The cost of reaching an out-of-bounds cell should ideally be considered as infinite or a very large value, indicating that reaching such a cell is not feasible.

//Minimum Path Calculation: When determining the minimum path from the current cell to the destination, considering 0 as the cost of reaching an out-of-bounds cell could incorrectly influence the minimum calculation. It might lead the algorithm to choose a path that passes through out-of-bounds cells, which is not valid.



passed 62/63 cases

 

 class Solution {
     int dp [][];
     public int minPathSum(int[][] grid) {
        
        
         int n = grid.length;
         int m = grid[0].length;
         dp = new int[n][m];
         for( int arr[] :dp)
         {
             Arrays.fill(arr,-1);
         }
         int ans  = solve(0,0,dp,grid,m,n);
         return ans;
     }
     public int solve( int i, int j ,int [][]dp, int grid[][], int m, int n)
     {
        
         if (i == n - 1 && j == m - 1) {
             return grid[i][j];
         }
        
         if( i<0 ||j<0|| j==m || i ==n || j>m || i>n  )
         {
             return 0;
         }
         if( dp[i][j] != -1)
         {
             return dp[i][j];
         }
        
         int anss =0;
         int right =  solve( i,j+1,dp,grid,m,n);
         int down =  solve( i+1, j, dp, grid,m,n);
         if( right ==0)
         {
             anss = down + grid[i][j];
         }
         if( down == 0)
         {
             anss = right + grid[i][j];
         }
         if( down !=0 && right !=0)
         {
             anss = Math.min( right + grid[i][j], down + grid[i][j]);
         }
        
         dp[i][j] = anss;
         return anss;
     }
 }







