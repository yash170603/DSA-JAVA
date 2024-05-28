class Solution {
    int dp[][];
    int n;
    int tax;
    public int maxProfit(int[] prices, int fee) {
        n= prices.length;
        dp= new int[n+1][2];
        tax = fee;
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);

        }

        return solve(0,0,prices);
    }


    public int solve(int index, int  buy, int [] prices)
    {
        if(index == n)
        {
            return 0;
        }

        if(dp[index][buy] != -1)
        {
            return dp[index][buy];
        }


        if(buy ==0)
        {
            return dp[index][buy] = Math.max(-prices[index]+solve(index+1,1,prices), solve(index+1,0,prices));
        }

        else
         return dp[index][buy]= Math.max((prices[index]-tax) +solve(index+1,0,prices),  solve(index+1,1,prices) );
    }


}



// bottom up

class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int dp[][]= new int [n+1][2];


        dp[n][0]=dp[n][1]=0;


        for(int index= n-1; index>=0;index--)
        {
            for(int buy =0; buy <=1;buy++)
            {
                if(buy ==0)
                {
                    dp[index][buy] = Math.max(-prices[index]+dp[index+1][1],dp[index+1][0]);
                }
                

                else
                {
                    dp[index][buy]= Math.max((prices[index]-fee) +dp[index+1][0] , dp[index+1][1] );
                }
            }
        }


        return dp[0][0];
    }
}
