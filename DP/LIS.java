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
