class Solution {
    int N;
    int M;
    int K;
    int mod = 1000000007;
    int [][][] dp = new int [51][51][101]; // index,length of lis, max value
    public int numOfArrays(int n, int m, int k)
     {
         N=n;
         M=m;
         K=k;
         for( int [][] t : dp)
         {
             for( int [] kk: t)
             {
                 Arrays.fill(kk,-1);
             }
         }

         return solve(0,0,0);
         
        
    }

    public int solve( int index, int llis, int max)
    {
        if( index == N)
        {
            if( llis == K)
            {
                return 1;
            }
            return 0;
        }

        if( dp[index][llis][max] != -1)
        return dp[index][llis][max] ;
        int result =0;
        for( int i =1; i<=M;i++)
        {
            if( i> max)
            {
              result = ((result + solve( index+1, llis+1, i))) % mod;
            }
            else
            {
                    result = ((result + solve( index+1, llis, max))) % mod;
            }
        }
  
  return dp[index][llis][max]= result%mod;

    }


}
