class Solution {
    int dp [][];
    int n;
    public int lengthOfLIS(int[] nums) {

        n = nums.length;
        dp = new int [2501][2501];
        for( int arr[] : dp)
        {
            Arrays.fill(arr,-1);
        }
        

        return solve( 0,-1,nums);
    }

    public int solve( int index, int prev, int [] nums)
    {
        if( index>= nums.length)
        {
            return 0;
        }

        if(   prev !=-1 && dp[index][prev] != -1) 
        {
            return dp[index][prev];
        }

        // take, when there is no elements before i.e prev == -1 or next element is greater
        int take=0;
        if( prev == -1 || nums[index]>nums[prev])
        {
            take = 1+ solve( index+1, index,nums);
        }

        int skip = solve(index+1,prev,nums);
  

  if( prev != -1)
  {
      dp[index][prev]= Math.max( take,skip);
  }
        return Math.max( take,skip);
    }

}  

// bottom up visit     https://drive.google.com/drive/folders/11brmmOX0o97rqK1HCVO42girgzNB8xKx
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] t = new int[n];
        Arrays.fill(t,1);
    
        int maxLIS = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }

        return maxLIS;
    }
}




// lis using binary search

    import java.util.*;

class LIS {
    // Function to find the length of the longest increasing subsequence
    static int longestIncreasingSubsequence(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                // arr[i] > the last element of temp array

                temp.add(arr[i]);
                len++;
            } else {
                // Replacement step
                int ind = Collections.binarySearch(temp, arr[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }

                temp.set(ind, arr[i]);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " +
                longestIncreasingSubsequence(arr, n));
    }
}

