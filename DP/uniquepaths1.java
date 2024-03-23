class Solution {
  
  int ans;
    
    public int uniquePaths(int m, int n) {
         ans =0;
        
          int [][]dp= new int [m][n];
         for( int p[] : dp)
         {
            Arrays.fill(p,-1);
         }
           ans =solve(0,0,m,n,dp);
         return ans;
    }

    public int solve(int i,int j, int m , int n , int [][] dp)
    {
        if(i == m-1 && j == n-1)
        {
            return 1 ;
        }

        if( i<0||j<0 ||i>=m||j>=n)
        {
            return 0;
        }

        if( dp[i][j] != -1)
        {
            return dp[i][j];
        }

        //    ans =  ans+ solve(i+1,j,m,m,dp);
        //    ans= ans+ solve(i,j+1,m,n,dp);
        

        // dp[i][j]=ans;
        // return ans;
          int paths = solve(i + 1, j, m, n, dp) + solve(i, j + 1, m, n, dp);

        dp[i][j] = paths;
        return paths;
    }
}


