//top down
class Solution {
    int dp[][];
    int n ;
    int m;
    public int numDistinct(String s, String t)
     {

        n= s.length();
        m= t.length();
        if(n<m)
        return 0;
        dp = new int[n+1][m+1];
        for( int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }

        return solve(0,0,s,t);
         
    }

    public int solve( int indexi, int indexj, String s1, String s2)
    {
        if( indexi ==n|| indexj==m)
        {
            if(indexj==m)
            return 1;

            return 0;
        }

        if(dp[indexi][indexj]!=-1)
        {
            return dp[indexi][indexj];
        }

        if( s1.charAt(indexi) == s2.charAt(indexj))

        {
            return dp[indexi][indexj]= solve(indexi+1,indexj+1,s1,s2)+ solve(indexi+1,indexj,s1,s2);
        }
   
     
        return dp[indexi][indexj]=solve(indexi+1,indexj,s1,s2);
    }
}


//bottomup


class Solution {
    int dp[][];
    int n ;
    int m;
    public int numDistinct(String s, String t)
     {

        n= s.length();
        m= t.length();
        if(n<m)
        return 0;
        // dp = new int[n+1][m+1];
        // for( int arr[]:dp)
        // {
        //     Arrays.fill(arr,-1);
        // }

        // return solve(0,0,s,t);

        dp = new int[n+1][m+1];
        for(int i =0;i<=n;i++)
        {
            dp[i][0]= 1;
        }
        // for( int j =0;j<=m;j++)
        // {
        //     dp[0][j]=1;
       // }

        for(int k=1;k<=n;k++)
        {
            for( int l=1;l<=m;l++)
            {
                  if(s.charAt(k-1) == t.charAt(l-1))
                  {
                    dp[k][l]= dp[k-1][l-1]+dp[k-1][l];
                  }
                  else
                  dp[k][l]= dp[k-1][l];
            }
        }

        return dp[n][m];
         
    }

    // public int solve( int indexi, int indexj, String s1, String s2)
    // {
    //     if( indexi ==n|| indexj==m)
    //     {
    //         if(indexj==m)
    //         return 1;

    //         return 0;
    //     }

    //     if(dp[indexi][indexj]!=-1)
    //     {
    //         return dp[indexi][indexj];
    //     }

    //     if( s1.charAt(indexi) == s2.charAt(indexj))

    //     {
    //         return dp[indexi][indexj]= solve(indexi+1,indexj+1,s1,s2)+ solve(indexi+1,indexj,s1,s2);
    //     }
   
     
    //     return dp[indexi][indexj]=solve(indexi+1,indexj,s1,s2);
    // }
}
