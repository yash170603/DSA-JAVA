class Solution { 
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n + 1][2];

        dp[n][0] = 0; // If there are no days left, profit is 0
        dp[n][1] = 0; // If there are no days left, profit is 0

        for (int index = n - 1; index >= 0; index--) {
            // For buy state
            dp[index][0] = Math.max(-prices[index] + dp[index + 1][1], dp[index + 1][0]);
            // For sell state
            if (index + 2 <= n) {
                dp[index][1] = Math.max(prices[index] + dp[index + 2][0], dp[index + 1][1]);
            } else {
                dp[index][1] = Math.max(prices[index], dp[index + 1][1]);
            }
        }

        return dp[0][0];
    }
}//



// top doiuwn

class Solution { 
    int dp[][];
    int n;
    public int maxProfit(int[] prices)
     {
        n= prices.length;
        dp= new int [n+1][3];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }

        return solve(0,0,prices);
    }

    public int solve(int index, int buy, int [] prices)
    {
        if(index >= prices.length)
        {
            return 0;
        }

         if(dp[index][buy] !=-1)
         {
            return dp[index][buy];
         }

         if(buy ==0)
         {
            return dp[index][buy] = Math.max(-prices[index]+solve(index+1,1,prices)  , 0+ solve(index+1,0,prices));
         }

         return dp[index][buy] = Math.max(prices[index]+solve(index+2,0,prices), solve(index+1,1,prices));
    }
}
