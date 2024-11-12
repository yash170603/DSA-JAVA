class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans =Integer.MAX_VALUE;
        int i=0,j=0,n=nums.length;
        int sum=0;
        while( i<n){
              sum+=nums[i];
              while(j<=i && sum>=target){
                ans= Math.min( ans, i-j+1);
                sum-=nums[j];
                j++;
              }
              i++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
