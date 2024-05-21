//wrong code.,
// didnt do manipulationof indexs on both strings
// no  need for stringbuilder, do it directly on indexs

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e') for this i wrote this  class Solution {
    int n;
    int m;
    int dp[][];
    public int minDistance(String w1, String w2)
     {
        n= w1.length();
        m= w2.length();
        dp= new int[n+1][m+1];

        for(int arr[]:dp)
        {Arrays.fill(arr,-1);}
        StringBuilder s1 = new StringBuilder(w1);
        StringBuilder s2 = new StringBuilder(w2);
        return solve(0,0,s1,s2);
    }

    public int solve(int index1,int  index2,StringBuilder s1, StringBuilder s2)
    {
        if( index1==n||index2==m)
        {
            if( index1==n)
            {
                    String temp= s2.substring(index2);
                     return temp.length();
            }
            
                     String temp2= s1.substring(index1);
                      return temp2.length();
            
        }
        if(dp[index1][index2] !=-1)
        return dp[index1][index2];
           int ans=0;
        if( s1.charAt(index1) == s2.charAt(index2))
        {
            return dp[index1][index2]= solve(index1+1,index2+1,s1,s2);
        }
        else
        {
            char c = s1.charAt(index1);
            char ch = s2.charAt(index2);
             s1.setCharAt(index1,ch);
            int replaced = solve(index1+1,index2+1,s1,s2);
            s1.deleteCharAt(index1);
            int del = solve( index1+1,index2,s1,s2);

            ans = 1+ Math.min(replaced,del);
        }
        return dp[index1][index2]= ans;
    }
},




// good one
class Solution {
    int n, m;
    int[][] dp;

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int[n + 1][m + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, word1, word2);
    }

    public int solve(int index1, int index2, String word1, String word2) {
        if (index1 == n) {
            return m - index2; // Remaining characters in word2 need to be inserted
        }
        if (index2 == m) {
            return n - index1; // Remaining characters in word1 need to be deleted
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        int ans;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            ans = solve(index1 + 1, index2 + 1, word1, word2);
        } else {
            int replaced = solve(index1 + 1, index2 + 1, word1, word2);
            int deleted1 = solve(index1 + 1, index2, word1, word2);
            int deleted2 = solve(index1, index2 + 1, word1, word2);
           ans = 1 + Math.min(replaced, Math.min(deleted1, deleted2));
           // ans= 1+Math.min(replaced,deleted1);
        }

        return dp[index1][index2] = ans;
    }
}





//bottom up

class Solution {
    int dp[][];
    int n;
    int m;

    public int minDistance(String w1, String w2) {
        
        n = w1.length();
        m = w2.length();
        dp = new int [n+1][m+1];
        

        for( int i=0;i<=n;i++)
        {
            dp[i][0]=i;
        }

        for(int j =0;j<=m;j++)
        {
            dp[0][j] =j;
        }

        for( int k=1;k<=n;k++)
        {
            for( int l=1;l<=m;l++)
            {
                if(w1.charAt(k-1) == w2.charAt(l-1))
                {
                    dp[k][l]= dp[k-1][l-1];
                }
                else
                {
                    dp[k][l]= 1+Math.min(dp[k-1][l-1],Math.min(dp[k-1][l],dp[k][l-1]));
                }
            }
        }
    return dp[n][m];

    }
}
