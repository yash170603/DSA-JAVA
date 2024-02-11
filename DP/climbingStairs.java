class Solution { // rec+ memo
     public int dp [];
    public int climbStairs(int n)
     {
       dp  = new int [50];
      Arrays.fill(dp,-1);

      return solve(n);
        
    }

    public int solve( int x)
    {
        if( x<0)return 0;
        if( x == 0) return 1;
        if( dp[x] != -1)
        return dp[x];
        return  dp[x] =solve( x-1)+ solve( x-2);

    }
}

// bottom upo
import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
