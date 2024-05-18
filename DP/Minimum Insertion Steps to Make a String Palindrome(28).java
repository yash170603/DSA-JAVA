class Solution {
    int n;
    int dp[][];
    public int minInsertions(String s) {
        n= s.length();
        dp= new int [n+1][n+1];
        for( int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return solve(s,0,n-1);

    }
    public int solve( String s, int indexi, int indexj)
    {
        if( indexi > indexj || (indexi ==n|| indexj<0))
        {
            return 0;
        }

        if( dp[indexi][indexj] != -1)
        {
            return dp[indexi][indexj];
        }
        if( s.charAt(indexi) != s.charAt(indexj))
        {
            return dp[indexi][indexj] = 1+ Math.min(solve( s, indexi, indexj-1), solve(s,indexi+1,indexj));
        }

        return dp[indexi][indexj] = 0+ solve( s, indexi+1,indexj-1);
    }
}


//bottom up
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // Fill the table from the bottom up
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}

