class Solution {
    public int findLengthOfShortestSubarray(int[] nums) {
           int n=nums.length;
           int j=n-1;
           while( j>0 && nums[j]>=nums[j-1]) j--;
           int ans=j;    // from j to left(inclusive) everything is sorted.
           if( j==0) return 0;
           int i=0;
           while( i<j && (i==0 || nums[i]>=nums[i-1])){
               while( j<n && nums[i]>nums[j]){
                j++;
               }
               ans=Math.min( ans, j-i-1);
               i++;
           }
      return ans;
    }
}
