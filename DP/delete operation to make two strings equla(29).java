//top down
class Solution {
    int n;
    int m;
    int dp[][];
    public int minDistance(String word1, String word2) 
    {

        n= word1.length();
        m = word2.length();
        dp = new int[n+1][m+1];
        for( int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return solve(0,0,word1,word2)-1;
        
    }

    public int solve( int index1, int index2, String s1, String s2)
    {
        if( index1==n || index2==m)
        {
            if(  index1  == n)
            {
                return m-index2+1;
            }

            return n-index1+1;
        }
        if( dp[index1][index2] !=-1)
        return dp[index1][index2];


        if( s1.charAt(index1) != s2.charAt(index2))
        {
            return dp[index1][index2] = 1+Math.min(solve(index1+1,index2,s1,s2), solve(index1,index2+1,s1,s2));
        }

        return dp[index1][index2]= solve(index1+1,index2+1,s1,s2);
    }
}

// bottom up

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // Create the DP table
        int[][] dp = new int[n + 1][m + 1];
        
        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] =i; // If word2 is empty, remove all characters from word1
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j ; // If word1 is empty, insert all characters of word2
        }
        
        // Fill the DP table bottom-up
        for (int i =1; i <=n; i++) {
            for (int j = 1; j <=m; j++ ){
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, move diagonally
                } else {
                    dp[i][j] = 1 + Math.min(dp[i -1][j], dp[i][j -1]); // Either delete from word1 or insert into word1
                }
            }
        }
        
        return dp[n][m]; // The result is in the top-left cell of the table
    }
}
