class Solution {
    int target ;
    int n;
    int dp[][];
    public int change(int amount, int[] coins) 
    {
        target = amount;
        n= coins.length;
        dp = new int[n+1][target+1];
        for( int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return solve( 0,0,coins);      
    }
    public int solve( int currindex, int currsum, int coins[])
    {
          if( currsum == target)
          return 1;
          if( currindex>=n || currsum>target)
          return 0;
          if( dp[currindex][currsum] !=-1)
          return dp[currindex][currsum];
          int take =0;
           if( coins[currindex]<=target && currsum<=target)
           {
            take = solve( currindex, currsum+coins[currindex],coins);
           }
           int skip = solve( currindex+1, currsum,coins);
           return dp[currindex][currsum] = (take+skip);
    }
}
