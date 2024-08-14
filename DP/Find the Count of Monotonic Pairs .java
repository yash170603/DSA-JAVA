1->
class Solution {
    int mod =1000000007;
    int dp[][];
    int n;
    public int countOfPairs(int[] nums) {
       n= nums.length;
       dp= new int[n+1][51];

       for( int arr[]:dp){
        Arrays.fill(arr,0);
       }

       for( int i= 0 ; i <= nums[0];i++){
           dp[0][i]=1;
       }


       for( int index = 1; index<n;index++){
        for( int curr=0;curr<=nums[index];curr++){
            int ways=0;
            for(int prev=0;prev<=50;prev++){
                if( curr>=prev && nums[index]-curr<=nums[index-1]-prev){
                    ways= (ways%mod+dp[index-1][prev]%mod)%mod;
                }
            }
            dp[index][curr]=ways;
        }
       }

       int ans=0;
       for( int val=0;val<=50;val++){
        ans= (ans%mod + dp[n-1][val]%mod)%mod;
       }
        
        return ans;
    }
}


2->

class Solution {
    int mod =1000000007;
    int dp[][];
    int n;
    public int countOfPairs(int[] nums) {
       n= nums.length;
       dp= new int[n+1][1001];

       for( int arr[]:dp){
        Arrays.fill(arr,0);
       }

       for( int i= 0 ; i <= nums[0];i++){
           dp[0][i]=1;
       }


       for( int index = 1; index<n;index++){
        int ways=0;
        int prev=0;
        for( int curr=0;curr<=nums[index];curr++){
                if( prev<= Math.min(curr,curr+nums[index-1]-nums[index])){//////////////////////////////////////////////////////////
                    ways= (ways%mod+dp[index-1][prev]%mod)%mod;
                    prev++;
                }
            dp[index][curr]=ways;
        }
       }

       int ans=0;
       for( int val=0;val<=1000;val++){
        ans= (ans%mod + dp[n-1][val]%mod)%mod;
       }
        
        return ans;
    }
}



The condition prev <= Math.min(curr, curr + nums[index-1] - nums[index]) 
is derived to ensure that we only consider prev values that satisfy both constraints simultaneously.
  This optimizes the calculation by narrowing down the range of valid prev values,
  reducing unnecessary iterations and ensuring that only valid pairs are considered in the dynamic programming approach.
