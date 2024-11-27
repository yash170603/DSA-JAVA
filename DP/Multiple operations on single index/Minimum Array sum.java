// class Solution {
//     int [][][]dp;
//     int n;
//     public int minArraySum(int[] nums, int k, int op1, int op2) {
//             n= nums.length;
//           dp = new int[n+1][op1+1][op2+1];
//           for(int [][]arr:dp){
//             for( int [] x:arr){
//                 Arrays.fill(x,-1);
//             }
//           }
//           return solve( 0,op1,op2,nums,k);
//     }

//     public int solve( int index, int op1, int op2, int [] nums, int k){
//           if( op1<0  && op2<0) return (int) 5e7;
//           if( index >=n) return 0;
//           if(dp[index][op1][op2]!=-1)return dp[index][op1][op2];

//           int one = (op1>0)? solve(index+1,op1-1,op2,nums,k) + nums[index]+1/2 :Integer.MAX_VALUE;
//           int two = (op2>0 && nums[index]>=k)? solve(index+1,op1,op2-1,nums,k) + nums[index]-k:Integer.MAX_VALUE;
//           int one2= ( op1>0 && op2>0 && nums[index]+1/2>=k)? solve( index+1, op1-1,op2-1,nums,k)+ (nums[index]+1)/2 + nums[index]+1/2-k:Integer.MAX_VALUE;
//           int two1= (op1>0 && op2>0 && nums[index]>=k)? solve( index+1, op1-1,op2-1,nums,k)+ nums[index]-k+ nums[index]-k+1/2:Integer.MAX_VALUE;

//           return dp[index][op1][op2]=Math.min(one,Math.min(two,Math.min(one2,two1)));
//     }
// }

import java.util.*;

class Solution {
    public int minArraySum(int[] nums, int K, int op1, int op2) {
        int n = nums.length;
        int[][][] dp = new int[n][n + 1][n + 1];

        // Initialize dp array with -1 (to represent uncomputed states)
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return helper(0, op1, op2, nums, K, dp);
    }

    private int helper(int i, int j, int k, int[] nums, int K, int[][][] dp) {
        if (j < 0 || k < 0) return (int) 1e7; 
        if (i == nums.length) return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];

        // Case 1: Do nothing
        int nothing = helper(i + 1, j, k, nums, K, dp) + nums[i];

        // Case 2: Use one operation (op1)
        int one = (j > 0) 
            ? helper(i + 1, j - 1, k, nums, K, dp) + (nums[i] + 1) / 2 
            : (int) 1e7;

        // Case 3: Use two operations (op2)
        int two = (nums[i] >= K) 
            ? helper(i + 1, j, k - 1, nums, K, dp) + (nums[i] - K) 
            : Integer.MAX_VALUE;

        // Case 4: Use one operation and then two operations
        int onetwo = ((nums[i] + 1) / 2 >= K) 
            ? helper(i + 1, j - 1, k - 1, nums, K, dp) + ((nums[i] + 1) / 2 - K) 
            : Integer.MAX_VALUE;

        // Case 5: Use two operations and then one operation
        int twoone = (nums[i] >= K) 
            ? helper(i + 1, j - 1, k - 1, nums, K, dp) + (nums[i] - K + 1) / 2 
            : Integer.MAX_VALUE;

        // Store and return the minimum of all cases
        dp[i][j][k] = Math.min(nothing, 
                        Math.min(one, 
                        Math.min(two, 
                        Math.min(onetwo, twoone))));
        return dp[i][j][k];
    }
}
