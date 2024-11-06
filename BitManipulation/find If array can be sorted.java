class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n-1;i++){
        
           if( nums[i]<=nums[i+1]) continue;
           else{ 
                int j=i;
                int maxIndex=-1;
               while( j>=0 && nums[j]>nums[i+1]){
                 if( Integer.bitCount(nums[j])!=Integer.bitCount(nums[i+1]) )return false;
                  if( nums[j]>nums[j+1]){
                     maxIndex=j;
                  }
                 j--;
               }
               j= (j==-1)?0:j;
               nums[i+1]=nums[maxIndex];
           }
        }
        return true;
    }
}
