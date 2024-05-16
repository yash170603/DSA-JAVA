import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int T) {
        int n = coins.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n + 1][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Calculate the minimum number of elements to achieve the target sum
        int ans = minimumElementsUtil(coins, 0, T, dp); // Start from index 0

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public int minimumElementsUtil(int[] coins, int ind, int T, int[][] dp) {
        // Base case: If the current index is n - 1
        if (ind == coins.length - 1) {
            // If T is divisible by the last element of the array, return the quotient
            if (T % coins[ind] == 0)
                return T / coins[ind];
            else
                // If not, return a large value to indicate it's not possible
                return (int) Math.pow(10, 9);
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the minimum number of elements needed without taking the current element
        int notTaken = 0 + minimumElementsUtil(coins, ind + 1, T, dp); // Move to the next index

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to T, calculate the minimum taking it
        if (coins[ind] <= T)
            taken = 1 + minimumElementsUtil(coins, ind, T - coins[ind], dp);

        // Store the minimum result in the dp array and return it
        return dp[ind][T] = Math.min(notTaken, taken);
    }
}




//bottom up
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int T) {
        int n = coins.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n + 1][T + 1];

        // Initialize the dp array with a large value to indicate that subproblems are not solved yet
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], (int) Math.pow(10, 9));
        }

        // Base case: When the target is 0, the minimum number of coins required is 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Fill the dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= T; j++) {
                // If the current coin denomination is greater than the target amount,
                // take the value from the previous row (without using this coin)
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, take the minimum of (1 + dp[i][j - coins[i - 1]]) and the value from the previous row
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                }
            }
        }

        // If it's not possible to achieve the target sum, return -1
        if (dp[n][T] >= (int) Math.pow(10, 9)) {
            return -1;
        }
        return dp[n][T];
    }
}
