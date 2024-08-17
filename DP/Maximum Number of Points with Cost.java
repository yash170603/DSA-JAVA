class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prev = new long[n];

        // Initialize the first row
        for (int col = 0; col < n; col++) {
            prev[col] = points[0][col];
        }

        // Process each subsequent row
        for (int i = 1; i < m; i++) {
            long[] curr = new long[n];
            long[] left = new long[n];
            long[] right = new long[n];

            // Fill left array
            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(prev[j], left[j - 1] - 1);
            }

            // Fill right array
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(prev[j], right[j + 1] - 1);
            }

            // Calculate current row's maximum points
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            // Update prev array for the next iteration
            prev = curr;
        }

        // Return the maximum value from the last row
        long max = Long.MIN_VALUE;
        for (long val : prev) {
            max = Math.max(max, val);
        }

        return max;
    }
}
