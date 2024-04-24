class Solution {
    int dp[];
    public int tribonacci(int n) {
        dp= new int[n+1] ;
        Arrays.fill(dp,-1);
       return solve( n, dp);
    }
    public int solve( int n, int dp[])
    {
         if(n ==0)
        return 0;
        if( n<=2)
        return 1;
        if( dp[n] !=-1)
        return dp[n];
        int a  = solve(n-3,dp);
        int b = solve(n-2,dp);
        int c= solve( n-1,dp);
        dp[n-3]=a;
        dp[n-2]=b;
        dp[n-1]=c;
        return a+b+c;
    }
}
