import java.util.*;

class Solution {
    int n;
    HashMap<Integer, Integer> map;

    public int countMaxOrSubsets(int[] nums) {
        map = new HashMap<>();
        n = nums.length;
        int maxOr = 0;
        int maxFrequency = 0;

        // Calculate the OR value for the entire array (to know the maximum possible OR).
        for (int num : nums) {
            maxOr |= num;
        }

        // Solve for all subsets starting from index 0 and initial OR value 0.
        solve(0, 0, nums);

        // Find the frequency of subsets with OR value equal to maxOr.
        maxFrequency = map.getOrDefault(maxOr, 0);

        return maxFrequency;
    }

    public void solve(int i, int currOr, int[] nums) {
        // If all elements have been considered, add the current OR value to the map.
        if (i >= n) {
            map.put(currOr, map.getOrDefault(currOr, 0) + 1);
            return;
        }

        // Include nums[i] in the subset (OR it with the current OR value).
        solve(i + 1, currOr | nums[i], nums);

        // Exclude nums[i] from the subset (keep the current OR value).
        solve(i + 1, currOr, nums);
    }
}
