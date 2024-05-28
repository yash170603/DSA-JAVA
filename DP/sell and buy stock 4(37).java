class Solution {
    public int maxProfit(int kk,int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // DP table
        int[][][] dp = new int[n+1][2][kk+1];

        // Initialize base cases
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= kk; k++) {
                dp[i][0][k] = 0;
                dp[i][1][k] = 0;
            }
        }

        // Fill the DP table
        for (int index = n-1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= kk; cap++) {
                    if (buy == 0) {
                        dp[index][buy][cap] = Math.max(
                            -prices[index] + dp[index+1][1][cap],
                            dp[index+1][0][cap]
                        );
                    } else {
                        dp[index][buy][cap] = Math.max(
                            prices[index] + dp[index+1][0][cap-1],
                            dp[index+1][1][cap]
                        );
                    }
                }
            }
        }

        return dp[0][0][kk];
    }
}



// top down
class Solution {
    int dp[][][];
    int n;
    public int maxProfit(int k,int[] prices) {
        n= prices.length;
        dp= new int [n+1][2][k+1];
        for( int arr[][]:dp)
        {
            for(int ar [] :arr )
            {
                Arrays.fill(ar,-1);
            }
        }
        return solve(0,0,k,prices);     
    }
    public int solve(int index, int buy, int cap,int [] prices)
    {
        if(index ==n || cap ==0)
        return 0;
        if(dp[index][buy][cap] !=-1)
        return dp[index][buy][cap];
        if( buy == 0)
        {
           return dp[index][buy][cap] = Math.max( -prices[index]+solve(index+1,1,cap,prices) , 0+ solve(index+1,0,cap,prices));
        }
        return dp[index][buy][cap]= Math.max( prices[index]+solve(index+1,0,cap-1,prices), solve(index+1,1,cap,prices));
    }
}
