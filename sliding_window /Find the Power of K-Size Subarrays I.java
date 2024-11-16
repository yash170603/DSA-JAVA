class Solution {
    public int[] resultsArray(int[] nums, int k) {
        
        if( k == 1) return nums;
        int n = nums.length;
        int [] ans= new int[n-k+1];
 
        for( int i=0;i<=n-k;i++){
            int end = i+k-1;
            int thisMax=-1;
            int j=i;
              for(;j<end;j++){
                 if(nums[j]!=nums[j+1]-1)break;
              }
              thisMax= j==end?nums[end]:-1;
              ans[i]=thisMax; 
        }
        return ans;
    }
}
