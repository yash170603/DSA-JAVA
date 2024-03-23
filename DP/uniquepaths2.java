class Solution {
      int ans;
    public int uniquePathsWithObstacles(int[][] matrix) {
          ans =0;
         int m= matrix.length;
         int n = matrix[0].length;
          int [][]dp= new int [m][n];
         for( int p[] : dp)
         {
            Arrays.fill(p,-1);
         }
           ans =solve(0,0,m,n,dp,matrix);
           if(matrix[m-1][n-1] ==1)
           return 0;
         return ans;

    }
     public int solve(int i,int j, int m , int n , int [][] dp,int[][] matrix)
    {
        if(i == m-1 && j == n-1 )
        {
            return 1 ;
        }

        if( i<0||j<0 ||i>=m||j>=n||matrix[i][j]==1)
        {
            return 0;
        }

        if( dp[i][j] != -1)
        {
            return dp[i][j];
        }
          int paths = solve(i + 1, j, m, n, dp,matrix) + solve(i, j + 1, m, n, dp,matrix);
        dp[i][j] = paths;
        return paths;
    }
}
