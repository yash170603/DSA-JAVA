class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int res = 0, maxi = 1;

        for (int i = 0; i < n; ++i) {
            for (int prev = 0; prev < i; ++prev) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                } else if (nums[prev] < nums[i] && 1 + dp[prev] == dp[i])
                    count[i] += count[prev];
            }
            maxi = Math.max(maxi, dp[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (dp[i] == maxi)
                res += count[i];
        }

        return res;
    }
}
