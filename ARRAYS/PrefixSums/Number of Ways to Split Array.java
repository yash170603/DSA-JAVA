class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long [] prefix= new long[n];
         prefix[0]=nums[0];
         for( int i=1;i<n;i++){
             prefix[i]=nums[i]+prefix[i-1];
         }
         int ans=0;
         for( int i =0;i<n-1;i++){
             if( prefix[i]>=prefix[n-1]-prefix[i])ans++;
         }
         return  ans;
    }
}
