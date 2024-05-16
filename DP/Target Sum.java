import java.util.*;

class Solution {
    int n;
    int target;
    HashMap<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int t) {
        n = nums.length;
        target = t;
        memo = new HashMap<>();
        return solve(0, 0, nums);
    }

    public int solve(int currIndex, int currSum, int[] nums) {
        if (currIndex == n) {
            if (currSum == target)
                return 1;
            return 0;
        }
        // if (currSum == target)
        //     return 1;
        // if (currSum > target)
        //     return 0;
      bcs we are not working on subseq here
        

        String key = currIndex + "_" + currSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int pos = solve(currIndex + 1, currSum + nums[currIndex], nums);
        int neg = solve(currIndex + 1, currSum - nums[currIndex], nums);

        int result = pos + neg;
        memo.put(key, result);
        return result;
    }
}




// 2nd approach was to use code from dp 18, number of subsets whose difference is k.
// all postive(in one set) and all negative in other(set) total sum= summ array,
passed 135/140 test cases. loses on 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0

  class Solution {
     int n ;
     int target;
     int dp[][];
     int totsum;
    public int findTargetSumWays(int[] arr, int d) 
    {
        n = arr.length;
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
        return solve(0, 0, arr) ;
    }

 public  int solve(int currentIndex, int currentSum, int[] arr) {
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
    
        int take = solve(currentIndex + 1, currentSum + arr[currentIndex], arr) ;
        int skip = solve(currentIndex + 1, currentSum, arr) ;
        return dp[currentIndex][currentSum] = (take + skip) ;
    }
}
