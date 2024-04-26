class Solution {
    int dp[][];
    int n;
    int k;
    String s;

    public int longestIdealString(String ss, int K) {
        k = K;
        n = ss.length();
        s = new String(ss);
        dp = new int[n+1][27];
        for( int arr[]:dp) {
            Arrays.fill(arr,-1);
        }

        return solve(0, 1,-1);
    }

    public int solve(int index, int length, int prev) {

        if(index>=n)
        return 0;
          if(prev !=-1)
          {
                 if( dp[index][prev] != -1)
                 {
                    return dp[index][prev];
                 }
                 
              
          }
       
          
          int take=0;
        if( prev == -1 ||  Math.abs((int)(s.charAt(index)) - (int)(s.charAt(prev))) <= k )
        {
            take= 1+solve(index+1,length+1,index);
        }
        int skip = solve(index + 1, length,prev);
        return dp[index][length] = Math.max(take, skip);
      
    }
}
