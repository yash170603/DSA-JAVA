// 3 ptr
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
           int res = 0, odd = 0;
        int l = 0, m = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1) {
                odd += 1;
            }

            while (odd > k) {
                if (nums[l] % 2 == 1) {
                    odd -= 1;
                }
                l += 1;
                m = l;
            }

            if (odd == k) {
                while (m < nums.length && nums[m] % 2 == 0) {
                    m += 1;
                }
                res += (m - l) + 1;
            }
        }
        return res;
   
    }
}
