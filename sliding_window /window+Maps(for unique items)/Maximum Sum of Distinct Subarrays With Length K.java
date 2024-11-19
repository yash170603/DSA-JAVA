class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0,j=0,n=nums.length;
        long ans=0,curr=0;
        HashSet<Integer> x = new HashSet<>();
          while(i<n){
               while( x.contains(nums[i])){
                x.remove(nums[j]);
                curr-=nums[j];
                j++;
               }
               curr+=nums[i];
               x.add(nums[i]);
               if( i-j+1==k){
                   ans=Math.max(ans,curr);
                    curr-=nums[j];
                    x.remove(nums[j]);
                    j++;
               }
               i++;
          }

          return ans;
    }
}
