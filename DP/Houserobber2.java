import java.util.Arrays;
  // rec+mem
class Solution {
    int[] t = new int[101];
    
    public int solve(int[] nums, int i, int n) {
        if (i > n)
            return 0;

        if (t[i] != -1)
            return t[i];

        int take = nums[i] + solve(nums, i + 2, n); // steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = solve(nums, i + 1, n); // skips this house, now we can move to adjacent next house

        return t[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        if (n == 2)
            return Math.max(nums[0], nums[1]);

        Arrays.fill(t, -1);

        // case-1 - Take first house 0th index wala house
        int take_0th_index_house = solve(nums, 0, n - 2);

        Arrays.fill(t, -1);

        // case-2 - Take second house 1st index wala house
        int take_1st_index_house = solve(nums, 1, n - 1);

        return Math.max(take_0th_index_house, take_1st_index_house);
    }
}
//bottom up
import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] t1 = new int[n + 1];
        int[] t2 = new int[n + 1];

        // Case-1 (Take from 1st House - Hence skip the last house)
        t1[0] = 0;
        for (int i = 1; i <= n - 1; i++) {
            t1[i] = Math.max(t1[i - 1], nums[i - 1] + ((i - 2 >= 0) ? t1[i - 2] : 0));
        }
        int result1 = t1[n - 1];

        // Case-2 (Take from 2nd House - Hence take the last house)
        t2[0] = 0;
        t2[1] = 0;
        for (int i = 2; i <= n; i++) {
            t2[i] = Math.max(t2[i - 1], nums[i - 1] + ((i - 2 >= 0) ? t2[i - 2] : 0));
        }
        int result2 = t2[n];

        return Math.max(result1, result2);
    }
}
