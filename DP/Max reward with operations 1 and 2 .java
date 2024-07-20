// part 1 recursive
class Solution {
    int dp[][];
    int n;
    public int maxTotalReward(int[] nums) {
        n= nums.length;
         Arrays.sort(nums);
        dp = new int[n+1][nums[n-1]];
        for( int arr[]:dp)
        Arrays.fill(arr,-1);
       
        return solve(0,0,nums);
    } 
    public int solve( int index, int sum, int [] nums){
     if( sum>=nums[n-1] || index==n)
     return sum;
        if( dp[index][sum]!= -1){
            return dp[index][sum];
        }
        int take = ( nums[index]>sum)?solve(index+1,sum+nums[index],nums):sum;
        int skip = solve( index+1, sum, nums);

        return dp[index][sum]= Math.max( take,skip);
    }
} 


bottom up
  import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxSum = nums[n - 1];

        int[][] dp = new int[n + 1][maxSum + 1];
        
        // Initialize the DP table with -1
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // Base case initialization: when index == n or sum >= maxSum
        for (int sum = 0; sum <= maxSum; sum++) {
            dp[n][sum] = sum;
        }

        // Fill the DP table iteratively
        for (int index = n - 1; index >= 0; index--) {
            for (int sum = 0; sum <= maxSum; sum++) {
                int take = sum;
                if (sum + nums[index] <= maxSum) {
                    take = dp[index + 1][sum + nums[index]];
                }
                int skip = dp[index + 1][sum];

                dp[index][sum] = Math.max(take, skip);
            }
        }

        // The result is stored in dp[0][0]
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 1, 3, 4, 2};
        System.out.println(solution.maxTotalReward(nums)); // Example usage
    }
}










2-, higher contrainst, dp+ bitmanipulation+masking -> tle too
  // Initialize the base case
    dp.set(0);

    // Sort the reward values
    Arrays.sort(rewardValues);

    int maskId = 0;
    for (int val : rewardValues) {
        // Update mask
        while (maskId < val) {
            mask.set(maskId++);
        }
        
        // Create validPrev by ANDing dp and mask
        validPrev.clear();
        validPrev.or(dp);
        validPrev.and(mask);

        // Update dp with shifted validPrev
        BitSet shifted = new BitSet(100001);
        for (int i = validPrev.nextSetBit(0); i >= 0; i = validPrev.nextSetBit(i + 1)) {
            if (i + val < 100001) {
                shifted.set(i + val);
            }
        }
        dp.or(shifted);
    }

    // Find the maximum possible sum
    int res = 100000;
    while (!dp.get(res)) {
        --res;
    }
    return res;
}

public static void main(String[] args) {
    Solution sol = new Solution();
    int[] rewardValues = {1, 2, 3, 4, 5};
    System.out.println(sol.maxTotalReward(rewardValues)); // Example usage
} 









  


now bs+ recusrion

  class Solution {
    
    Map<Integer, Integer> dp = new HashMap<>();
    
    public int maxTotalReward(int[] arr) {        
        arr = removeDups(arr);
        return arr[arr.length-1] + rec(arr, arr[arr.length-1] - 1);
    }
    
    private int rec(int[] arr, int lim) {
        if (lim == 0) {
            return 0;
        }
        if (dp.get(lim) != null) {
            return dp.get(lim);
        }
        int ind = find(arr, lim);
        if (ind == -1) {
            return lim;
        }
        int res = 0;
        for (int i = 0; i < ind; i++) {
            if (arr[i] * 2 - 1 <= res) {
                break;
            }
            res = Math.max(res, arr[i] + rec(arr, Math.min(lim - arr[i], arr[i] - 1)));
        }
        dp.put(lim, res);
        return res;
    }
    
    private int find(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) {
                return -1;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                res = mid;
                hi = mid - 1;
            }
        }
        return res;
    }
    
    private int[] removeDups(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr) {
            set.add(num);
        }
        int[] res = new int[set.size()];
        int i =0;
        for (int num: set) {
            res[i++] = num;
        }
        Arrays.sort(res);
        return res;
    }
}  


  
