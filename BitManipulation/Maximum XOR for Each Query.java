class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int prev[]= new int [nums.length];
        prev[0] = nums[0];
        for(int i =1;i<nums.length;i++){
            prev[i]= prev[i-1]^nums[i];
        }
        int mask= (1<<maximumBit)-1;
        int n=nums.length;
        for( int i=n-1;i>=0;i--){
            int ans = prev[i]^mask;
            prev[i]=ans;
        }
        int ans[]=new int[n];
        int index=0;
        for(int i=n-1;i>=0;i--){
            ans[index++]=prev[i];
        }
        return ans;
    }
}
