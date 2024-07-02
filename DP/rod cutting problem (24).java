
import java.util.Arrays;

class Solution {
    private int[][] dp;

    private int helper(int[] price, int[] length, int n, int i) {
        if (n == 0 || i == 0) return 0; // Base case: no rod or no price

        if (dp[n][i] != -1) return dp[n][i]; // Check cache for sub-problem

        if (length[n - 1] <= i) {
            // We can cut in current size or not, multiple sizes are allowed
            dp[n][i] = Math.max(price[n - 1] + helper(price, length, n, i - length[n - 1]), helper(price, length, n - 1, i));
        } else {
            // We can't cut in current size because we don't have enough size of rod
            dp[n][i] = helper(price, length, n - 1, i);
        }

        return dp[n][i];
    }

    public int cutRod(int[] price, int n) {
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        return helper(price, length, n, n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20};
        int n1 = 8;
        System.out.println("Maximum Obtainable Value: " + solution.cutRod(price1, n1)); // Output: 22

        int[] price2 = {3, 5, 8, 9, 10, 17, 17, 20};
        int n2 = 8;
        System.out.println("Maximum Obtainable Value: " + solution.cutRod(price2, n2)); // Output: 24
    }
}



// bottom up
class Solution {
    public int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        
        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i] = 0;
        }
        
        // Fill the dp array in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20};
        int n1 = 8;
        System.out.println("Maximum Obtainable Value: " + solution.cutRod(price1, n1)); // Output: 22

        int[] price2 = {3, 5, 8, 9, 10, 17, 17, 20};
        int n2 = 8;
        System.out.println("Maximum Obtainable Value: " + solution.cutRod(price2, n2)); // Output: 24
    }
}
