class Solution {
    public long minimumReplacement(int[] nums) {
        long ans=0;

        int n= nums.length;

        for( int i= n-2;i>=0;i--){
               
               if( nums[i]<=nums[i+1]){
                continue;
               }

               long parts = (long) ( nums[i])/(long) (nums[i+1]);
               if( nums[i]%nums[i+1] !=0) parts++;

               ans+=parts-1;
               nums[i]=nums[i] /(int) parts;
        }

        return ans;
    }
