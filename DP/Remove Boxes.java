import java.util.Arrays;

class Solution {
    public static int solve(int l, int r, int count, int[] boxes, int[][][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][count] != -1) {
            return dp[l][r][count];
        }

        // Skip consecutive boxes of the same color and increase the count
        int i = l;
        int v=count;
        while (i + 1 <= r && boxes[i + 1] == boxes[l]) {
            i++;
            v++;
        }
        
        // Case 1: Remove all consecutive boxes of the same color
        int maxPoints = (v + 1) * (v + 1) + solve(i+1, r, 0, boxes, dp);

        // Case 2: Try to merge with non-consecutive boxes of the same color
        for (int m = i+1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                // Combine points by considering removing middle boxes first
                int mergedPoints = solve(m, r, v + 1, boxes, dp) + solve(i+1 , m - 1, 0, boxes, dp);
                maxPoints = Math.max(maxPoints, mergedPoints);
            }
        }

        dp[l][r][count] = maxPoints;
        return maxPoints;
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return solve(0, n - 1, 0, boxes, dp);
    }
}
