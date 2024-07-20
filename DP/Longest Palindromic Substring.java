// iterative
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

       boolean[][] dp = new boolean[n][n];
        int[] longest = new int[]{0, 1};  // stores the start and length of the longest palindrome

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;  // every single character is a palindrome
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (length > longest[1]) {
                            longest[0] = i;
                            longest[1] = length;
                        }
                    }
                }
            }
        }

        return s.substring(longest[0], longest[0] + longest[1]);

}
}





//

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        // Memoization table to store results of subproblems
        Boolean[][] memo = new Boolean[n][n];
        int[] longest = new int[]{0, 0};  // stores the start and end of the longest palindrome

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, memo) && (j - i > longest[1] - longest[0])) {
                    longest[0] = i;
                    longest[1] = j;
                }
            }
        }

        return s.substring(longest[0], longest[1] + 1);
    }

     // Recursive method to check if s[i..j] is a palindrome
    private boolean isPalindrome(String s, int i, int j, Boolean[][] memo) {
        if (i >= j) return true;
        if (memo[i][j] != null) return memo[i][j];
        memo[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome(s, i + 1, j - 1, memo);
        return memo[i][j];
    }

}
