class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans []= new int[n];
        int prev =1;
        for( int i=0;i<n;i++ )
        {
            ans[i]= prev;
            prev = prev*nums[i];
        }
        prev =1;
        for( int j=n-1;j>=0;j--)
        {
            ans[j]= ans[j]*prev;
            prev=prev*nums[j];
        }

        return ans;
    }
}
