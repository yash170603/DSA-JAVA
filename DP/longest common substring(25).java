class Solution {
    int dp[][];
    int n;
    int m;
    public int longestCommonSubsequence(String text1, String text2) 
    {
        n= text1.length();
        m=text2.length();
        dp = new int[n+1][m+1];
        for( int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }

        return solve(text1,text2,0,0);
    }

    public int solve( String a, String b, int index1, int index2)
    {
        if( index1>=n || index2>=m)
        {
            return 0;
        }

        if(dp[index1][index2] !=-1)
        {
            return dp[index1][index2];
        }
        int match = 0;
        if( a.charAt(index1) == b.charAt(index2))
        {
           // match=1+solve(a,b,index1+1,index2+1);
            return dp[index1][index2]=1+solve(a,b,index1+1,index2+1);
        }

       // int notmatch = Math.max(solve(a,b,index1+1, index2), solve(a,b,index1,index2+1));

        // return dp[index1][index2]= Math.max(match,notmatch);
          return dp[index1][index2]= Math.max(solve(a,b,index1+1, index2), solve(a,b,index1,index2+1));

    }
}




//tabulation
class Solution {
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
