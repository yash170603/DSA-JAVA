class Solution { // bottom up
    public int rob(int[] nums)
     {
         int t[]= new int [101];
         t[0]=0;
         t[1]=nums[0];
         for( int i =2;i<=nums.length;i++)
         {
             int steal = nums[i-1]+t[i-2];
             int skip = t[i-1];
             t[i] = Math.max(steal,skip);
         }

         return t[nums.length];
    }

}

// 2nd approach
import java.util.Arrays;

class Solution {    //recursion+memoization
    int[] t = new int[101];

    public int solve(int[] nums, int i, int n) {
        if (i >= n)
            return 0;

        if (t[i] != -1)
            return t[i];

        int take = nums[i] + solve(nums, i + 2, n); // steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = solve(nums, i + 1, n); // skips this house, now we can move to adjacent next house

        return t[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(t, -1);
        return solve(nums, 0, n);
    }
}


// Approach-3 (Improving approach-2)
// See that it looks nothing but a fibonacci sequence. You just have to store last 2
// values (t[i-1] & t[i-2]) to find current value (t[i])
class Solution3 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 3)
            return n;

        int a = 1;
        int b = 2;
        int c = 3;

        for (int i = 3; i <= n; i++) {
            c = a + b;

            int temp_b = b;
            b = c;
            a = temp_b;

        }
        return c;
    }
}
