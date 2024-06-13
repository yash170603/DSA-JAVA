// bottom up
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;
        
        // Initialize the dp array and count the squares
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == n - 1 || j == m - 1) {
                        // Last row or last column can only form squares of size 1
                        dp[i][j] = 1;
                    } else {
                        // Cell value depends on the minimum of the right, down, and bottom-right cells plus 1
                        dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                    }
                    ans += dp[i][j];
                }
            }
        }
        
        return ans;
    }
}


// top down

class Solution {
    int n;
    int m;
    int dp[][];
    public int countSquares(int[][] matrix) {
        n=matrix.length;
        m= matrix[0].length;
        dp = new int [n][m];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for( int j=0;j<m;j++)
            {
               if(matrix[i][j] == 1)
               {
                ans +=  solve(i,j,matrix);
               }
            }
        }

        return ans;

    }

    public int solve ( int i, int j, int  [][] matrix)
    {
        if( i<0||j<0||i==n||j==m||matrix[i][j] ==0)
        {
            return 0;
        }
        if(dp[i][j] !=-1)
        return dp[i][j];
        int ans = 1 + Math.min(solve(i+1,j,matrix),Math.min(solve(i+1,j+1,matrix),solve(i,j+1,matrix)));
        return dp [i][j]= ans;

    }
}
