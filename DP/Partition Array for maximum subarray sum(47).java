class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        

        int n = arr.length;
        int dp[]= new int [n+1];
        dp[n]=0;


        for( int  j = n-1;j>=0;j--)
        {
             int count=0;
        int partmax =Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int len=0;
        for( int i =j;i< Math.min(j+k,n);i++)
        {
            len++;
            partmax = Math.max(partmax,arr[i] );
            int sum = ( partmax*len) + dp[i+1];
            ans = Math.max(ans, sum);
        }

        dp[j] = ans;
        }
     return dp[0];
    }

}

// top down

class Solution {
    int dp[];
    int n ;
    int k;
    public int maxSumAfterPartitioning(int[] arr, int kk) {
        
        n =arr.length;
        dp= new int [n];
        Arrays.fill(dp,-1);
        k=kk;

        return solve(0,arr);
    }
    public int solve(int index, int arr[])
    {
        if( index ==n)
        return 0;

        if( dp[index] != -1)
        return dp[index];

        int count=0;
        int partmax =Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int len=0;
        for( int i =index;i< Math.min(index+k,n);i++)
        {
            len++;
            partmax = Math.max(partmax,arr[i] );
            int sum = ( partmax*len) + solve( i+1,arr);
            ans = Math.max(ans, sum);
        }

        return dp[index] = ans;
        
    }

}
