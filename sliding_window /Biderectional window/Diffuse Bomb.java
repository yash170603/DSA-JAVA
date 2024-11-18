class Solution {
    public int[] decrypt(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        // If k is 0, the result is an array of zeros
        if (k == 0) return ans;

        int start = 1; // Initial window start
        int end = k;   // Initial window end

        // Adjust for negative k: reverse the sliding window direction
        if (k < 0) {
            k = Math.abs(k);
            start = n - k;
            end = n - 1;
        }

        // Calculate the initial window sum
        int windowSum = 0;
        for (int i = start; i <= end; i++) {
            windowSum += nums[i % n];
        }

        // Slide the window and calculate sums for all elements
        for (int i = 0; i < n; i++) {
            ans[i] = windowSum;

            // Update the window: subtract the outgoing element, add the incoming element
            windowSum -= nums[start % n];
            start++;
            end++;
            windowSum += nums[end % n];
        }

        return ans;
    }
}
