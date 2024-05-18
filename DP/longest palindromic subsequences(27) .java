// by lcs, bottom up dp
class Solution {
    public int longestPalindromeSubseq(String s) 
    {
        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        return longestCommonSubsequence(s, s1.toString());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        int dp [][]= new int [n+1][m+1];

        for( int i =0;i<n+1;i++)
        {
            dp[i][0]=0;
        }
        for( int j=0;j<m+1;j++)
        {
            dp[0][j]=0;
        }

        for( int a =1;a<=n;a++)
        {
            for( int b=1;b<=m;b++)
            {
                if( text1.charAt(a-1) == text2.charAt(b-1))
                {
                    dp[a][b]=1+dp[a-1][b-1];
                }

                else
                {
                    dp[a][b]= Math.max(dp[a][b-1], dp[a-1][b]);
                }
            }
        }
        return dp[n][m];
    }
}


// by normal dp, using 2 pointers
class Solution {
     int n;
     int dp[][];
    public int longestPalindromeSubseq(String s) {
         n= s.length();
         if(n ==1)
         return 1;
         dp = new int [n+1][n+1];
         for( int arr[]:dp)
         {
            Arrays.fill(arr,-1);
         }

         return solve(s,0,n-1);
    }
    public int solve( String s,int indexi, int indexj)
    {
        if( indexi>indexj ||(indexi>=n || indexj<0))
        {
            return 0;
        }
        if(indexi==indexj)
        {
            if(s.charAt(indexi)==s.charAt(indexj))
            return 1;
            return 0;
        }
        if( dp[indexi][indexj] !=-1)
        {
            return dp[indexi][indexj];
        }
   
        if(s.charAt(indexi)==s.charAt(indexj))
        {
            return dp[indexi][indexj] = 2+solve(s,indexi+1,indexj-1);
        }

        return dp[indexi][indexj]= Math.max( solve(s,indexi+1,indexj) , solve(s,indexi,indexj-1));
    }
}
