import java.util.Arrays;

class Solution {
    private int[][] memo;
    private int target;

    public int minimizeTheDifference(int[][] mat, int target) {
        this.target = target;
        int n = mat.length;
        int maxSum = 0;
        for (int[] row : mat) {
            for (int num : row) {
                maxSum += num;
            }
        }

        // Initialize memoization table with -1 (uncomputed state)
        memo = new int[n+1][maxSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(mat, 0, 0);
    }

    private int dfs(int[][] mat, int row, int sum) {
        if (row == mat.length) {
            return Math.abs(sum - target);
        }

        if (memo[row][sum] != -1) {
            return memo[row][sum];
        }

        int minDiff = Integer.MAX_VALUE;
        for (int num : mat[row]) {
            minDiff = Math.min(minDiff, dfs(mat, row + 1, sum + num));
        }

        memo[row][sum] = minDiff;
        return minDiff;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int target1 = 13;
        System.out.println(sol.minimizeTheDifference(mat1, target1)); // Output: 0

        int[][] mat2 = {{1}, {2}, {3}};
        int target2 = 100;
        System.out.println(sol.minimizeTheDifference(mat2, target2)); // Output: 94

        int[][] mat3 = {{1,2,9,8,7}};
        int target3 = 6;
        System.out.println(sol.minimizeTheDifference(mat3, target3)); // Output: 1
    }
}
