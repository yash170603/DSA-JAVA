class Solution {
    int n;
    int m;
    int dp[][];

    public int minFallingPathSum(int[][] matrix) {
       

        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int q = 0; q < m; q++) {

            ans = Math.min(ans,  solve(0, q, matrix));
        }

        return ans;
    }

    public int solve(int i, int j, int[][] matrix) {
        if (j >= 0 && i == n - 1 && j < m ) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // down = i+1,j
        // left = i+1,j-1
        // up = i+1,j+1
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (i + 1 < n && j < m ) {
            down = solve(i + 1, j, matrix);
        }
        if (i + 1 < n && j - 1 >= 0) {
            left = solve(i + 1, j - 1, matrix);
        }
        if (i + 1 < n && j + 1 < m ) {
            right = solve(i + 1, j + 1, matrix);
        }

        return dp[i][j] =  matrix[i][j] + Math.min(down, Math.min(left, right));

    }
}


//bottom up


class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
   for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal =Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    leftDiagonal = matrix[i][j] + dp[i - 1][j - 1];
                } //else {
                //     leftDiagonal += Integer.MAX_VALUE;
                // }

                int rightDiagonal =Integer.MAX_VALUE;
                if (j + 1 < m) {
                    rightDiagonal  = matrix[i][j] + dp[i - 1][j + 1];
                 }// else {
                //     rightDiagonal += Integer.MAX_VALUE;
                // }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }


         int maxi = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.min(maxi, dp[n - 1][j]);
        }

        return maxi;
    }
}
