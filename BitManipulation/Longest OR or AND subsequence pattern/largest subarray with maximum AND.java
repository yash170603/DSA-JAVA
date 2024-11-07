class Solution {
    public int longestSubarray(int[] nums) {
        int maxBitwiseAnd = Integer.MIN_VALUE;
        
        // Find the maximum value in the array
        for (int num : nums) {
            maxBitwiseAnd = Math.max(maxBitwiseAnd, num);
        }
        
        int maxi = 1;
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] == maxBitwiseAnd) {
                while (i < nums.length && nums[i] == maxBitwiseAnd) {
                    count++;
                    i++;
                }
                maxi = Math.max(maxi, count);
                count = 0;
            } else {
                i++;
            }
        }
        
        return maxi;
    }
}

//0(n), i dont think its too intutive
// its like finding the maximum and updating the streak in next if bloack
class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int result = 0;
        int streak = 0;

        for(int num : nums) {
            if(num > maxVal) {
                maxVal = num;
                result = 0;
                streak = 0;
                continue;
            }
            if(maxVal == num) {
                streak++;
            } else {
                streak = 0;
            }

            result = Math.max(result, streak);
        }

        return result+1;
    }
}
