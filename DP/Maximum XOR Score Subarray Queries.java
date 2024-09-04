recursive


  class Solution {
      
    // Recursive function to calculate XOR score of subarray from i to j
    private int getXOR(int[] nums, int i, int j, int[][] ans) {
        if (i == j) {
            return nums[i];
        } else if (ans[i][j] != 0) {
            return ans[i][j];
        } else {
            ans[i][j] = getXOR(nums, i, j - 1, ans) ^ getXOR(nums, i + 1, j, ans);
            return ans[i][j];
        }
    }

    // Recursive function to calculate maximum XOR score of subarray from i to j
    private int getMaxXOR(int[] nums, int i, int j, int[][] dp, int[][] ans) {
        if (i == j) {
            return nums[i];
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(ans[i][j], Math.max(getMaxXOR(nums, i, j - 1, dp, ans), getMaxXOR(nums, i + 1, j, dp, ans)));
            return dp[i][j];
        }
    }

    public int[] maximumSubarrayXor (int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] ans = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            ans[i][i] = nums[i];
            dp[i][i] = nums[i];
        }

        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];

            int xorScore = getXOR(nums, i, j, ans);
            int maxXorScore = getMaxXOR(nums, i, j, dp, ans);

            dp[i][j] = maxXorScore;
        }

        int[] q = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];

            q[k] = dp[i][j];
        }

        return q;
    }
}




iterative


  import java.util.*;

class Solution {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] ans = new int[n][n];
        int[][] dp = new int[n][n];

        // Initialize arrays with -1 for memoization
        for (int[] row : ans) Arrays.fill(row, -1);
        for (int[] row : dp) Arrays.fill(row, -1);

        // Calculate XOR score for all subarrays iteratively
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (length == 1) {
                    ans[i][j] = nums[i];
                } else {
                    ans[i][j] = ans[i][j - 1] ^ ans[i + 1][j];
                }
            }
        }

        // Calculate maximum XOR for all subarrays iteratively
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (length == 1) {
                    dp[i][j] = ans[i][j];
                } else {
                    dp[i][j] = Math.max(ans[i][j], Math.max(dp[i][j - 1], dp[i + 1][j]));
                }
            }
        }

        // Prepare result array for queries
        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            result[k] = dp[i][j];
        }

        return result;
    }
}
