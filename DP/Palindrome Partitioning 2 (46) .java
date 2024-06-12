class Solution {
    int n ;
    int dp[];
    String s;
    public int minCut(String ss)
    {
        n = ss.length();
        dp = new int [n];
        Arrays.fill(dp,-1);
        s=ss;
        return solve(0)-1;
    }
    

    public int solve( int index)
    {
        if( index == n)
        return 0;
        if( dp[index]!=-1)
        return dp[index];
     int mincost = Integer.MAX_VALUE;
        for( int i= index;i<n;i++)
        {
            String temp=s.substring(index,i+1);
          
            if( palindrome(temp) == true)
            {
                 int cost = 1+ solve(i+1);
                  mincost = Math.min(cost,mincost) ;
            }
        }
        return dp[index]= mincost;
    }

    public  boolean palindrome(String t)
    {
        int i =0;
        int j = t.length()-1;
        while( j>=i)
        {
            if( t.charAt(i) != t.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
