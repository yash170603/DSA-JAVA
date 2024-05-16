import java.util.* ;
import java.io.*; 

public class Solution {
    static int n ;
    static int target;
    static int dp[][];
    static int totsum;
    static int mod= 1000000007;

    public static int countPartitions(int N, int d, int[] arr) {
        n = N;
        totsum=0;
        Arrays.sort(arr);
        for(int u : arr) {
            totsum += u;
        }
        target = (totsum + d) / 2;
        if(totsum - d < 0) return 0;
         if((totsum - d) % 2 == 1) return 0;
              dp = new int[n + 1][target + 1];
               for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        return solve(0, 0, arr) % mod;
    }

    public static int solve(int currentIndex, int currentSum, int[] arr) {
        if(currentIndex<n)
        {
           if(currentSum == target && arr[currentIndex] ==0  ) // ||(currentSum == target && arr[currentIndex] == target) ,doesnt work
            return 2;
        } // handling zero
         
        if(currentSum == target)
        return 1;
        if(currentIndex>=n || currentSum>target)
        return 0;
        if(dp[currentIndex][currentSum] != -1)
         return dp[currentIndex][currentSum];
    
          int   take = solve(currentIndex + 1, currentSum + arr[currentIndex], arr) % mod;
 
        int skip = solve(currentIndex + 1, currentSum, arr) % mod;
        return dp[currentIndex][currentSum] = (take + skip) % mod;
    }
}
