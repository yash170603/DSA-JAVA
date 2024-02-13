//rec+memo
import java.util.Arrays;

class Solution {
    int n;
    long[][] t;

    public long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) {
            return 0;
        }
        if (t[idx][isEven ? 1 : 0] != -1)
            return t[idx][isEven ? 1 : 0];

        long skip = solve(idx + 1, nums, isEven);

        long val = nums[idx];
        if (!isEven) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !isEven) + val;

        return t[idx][isEven ? 1 : 0] = Math.max(skip, take);

    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(0, nums, true);
    }
}



//bottom up
import java.util.Arrays;

class Solution {
    int n;
    long[][] t;

    public long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) {
            return 0;
        }
        if (t[idx][isEven ? 1 : 0] != -1)
            return t[idx][isEven ? 1 : 0];

        long skip = solve(idx + 1, nums, isEven);

        long val = nums[idx];
        if (!isEven) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !isEven) + val;

        return t[idx][isEven ? 1 : 0] = Math.max(skip, take);

    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(0, nums, true);
    }
}
