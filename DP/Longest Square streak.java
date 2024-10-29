import java.util.*;

class Solution {
    // HashMap to store the length of square streak ending at each number
    private HashMap<Long, Integer> dp;
    
    public int longestSquareStreak(int[] nums) {
        // Sort the array first
        Arrays.sort(nums);
        
        // Initialize HashMap for memoization
        dp = new HashMap<>();
        
        // Track the maximum streak length
        int maxStreak = 0;
        
        // Create a HashSet for O(1) lookup
        HashSet<Long> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add((long)num);
        }
        
        // For each number, try to start a streak
        for (int num : nums) {
            maxStreak = Math.max(maxStreak, getStreakLength((long)num, numSet));
        }
        
        // Return -1 if no valid streak found (length < 2)
        return maxStreak >= 2 ? maxStreak : -1;
    }
    
    private int getStreakLength(long num, HashSet<Long> numSet) {
        // If we've already computed this streak, return it
        if (dp.containsKey(num)) {
            return dp.get(num);
        }
        
        // Calculate square of current number
        long square = num * num;
        
        // Base case: if square doesn't exist in array
        if (!numSet.contains(square)) {
            dp.put(num, 1);
            return 1;
        }
        
        // Recursive case: 1 + length of streak starting at square
        int length = 1 + getStreakLength(square, numSet);
        dp.put(num, length);
        return length;
    }
}////


.// idk why this doesnt works.
import java.util.*;
class Solution {
    int dp [];
    int n;
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
          n  = nums.length;
          dp = new int [n+1];
          //for( int arr[]:dp){
            Arrays.fill(dp,-1);
          //}
          int ans= solve(0,-1,nums);
          System.out.println(ans);
          if( ans<2) return -1;
          return ans;
         
    }

    public int solve(int index, int prev, int nums[]){
        if( index>=n) return 0;
         if( prev!=-1 && dp[index]!=-1) return dp[index];

        int take=0,skip=0;
        if( prev ==-1 || nums[prev]*nums[prev] == nums[index]){
            take = 1+ solve( index+1, index,nums);
        }
         
        skip= solve( index+1, prev,nums);
         if( prev!=-1) return dp[index]=Math.max(take, skip);
         return Math.max(take,skip);
    }
}
