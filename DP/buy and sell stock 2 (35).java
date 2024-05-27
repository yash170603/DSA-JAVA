//top down
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
         long[][] dp = new long[n+1][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Base case: If n is 0, return 0 profit
        if (n == 0)
            return 0;

        // Calculate the maximum profit using the recursive function
        long ans = getMaximumProfitUtil(prices, 0, 0, n, dp);
        return (int)ans;
    }
    public long getMaximumProfitUtil(int[] Arr, int ind, int buy, int n, long[][] dp) {
        // Base case
        if (ind == n)
            return 0;

        // If the result is already computed, return it
        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        long profit;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp),
                    -Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp));
        } else { // We can sell the stock
            profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp),
                    Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp));
        }

        // Store the result in the dp table and return it
        dp[ind][buy] = profit;
        return profit;
    }

}





// bottom up
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // Create a 2D array dp where dp[i][0] represents the maximum profit on day i with no stock in hand,
        // and dp[i][1] represents the maximum profit on day i with one stock in hand.
        long[][] dp = new long[n + 1][2];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = 0;
        }

        // Bottom-up calculation of maximum profit
        long profit=0;
       for(int i= n-1;i>=0;i--)
       {
        for(int buy =0;buy<=1;buy++)
        {
            if(buy == 0)
            {
               profit =Math.max(-prices[i]+dp[i+1][1],dp[i+1][0] );
            }
             if (buy == 1) { // We can sell the stock
                    profit =Math.max(0 + dp[i + 1][1], prices[i] + dp[i + 1][0]);
                }

                dp[i][buy] = profit;
        }
       }

        // The answer will be in dp[n][0], i.e., maximum profit with no stock in hand on the last day.
        return (int) dp[0][0];
    }
}
