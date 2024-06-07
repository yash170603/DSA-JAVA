class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int n=N;
        int dp[][]= new int[n][n];
        for(int ar[]:dp)
        {
            Arrays.fill(ar,-1);
        }
        
        ///return solve(1,n-1,dp,arrr);
        for( int i =0;i<n;i++)
        {
            dp[i][i]=0;
        }
        
        for( int i =n-1;i>=1;i--)
        {
            for(int j=i+1;j<n;j++ )
            {
                 
              int steps = Integer.MAX_VALUE;
                   for( int k = i;k<=j-1;k++)
                   {
                       steps= Math.min( (arr[i-1]*arr[k]*arr[j]) +dp[i][k]+dp[k+1][j],steps);
                    }
                    dp[i][j]=steps;
            }
        }
        
        return dp[1][n-1];
    }
    
    public static int solve( int i, int j, int[][]dp,int []arrr)
    {
        if(i==j)
        return 0;
        
        if( dp[i][j] !=-1)
        return dp[i][j];
        
        int steps = Integer.MAX_VALUE;
        for( int k = i;k<=j-1;k++)
        {
            steps= Math.min( (arrr[i-1]*arrr[k]*arrr[j]) +solve(i,k,dp,arrr)+solve(k+1,j,dp,arrr),steps);
        }
        
        return dp[i][j]= steps;
    }
}
