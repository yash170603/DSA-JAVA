//based on bottom up LCS
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
        int a =n;
        int b = m;
        StringBuilder ans= new StringBuilder();
        while( a>0 && b>0)
        {
            if( text1.charAt(a-1) == text2.charAt(b-1))
            {
                ans.append( text1.charAt(a-1));
                a--;
                b--;
            }
            else
            {
                if(dp[a-1][b]>dp[a][b-1])
                {
                    a--;
                }
                 else
                {
                    b--;
                }
            }
        }
        String s = ans.reverse().toString();
        System.out.println(s);
        // return dp[n][m];
    }
}
