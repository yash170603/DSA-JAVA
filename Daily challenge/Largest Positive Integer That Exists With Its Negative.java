class Solution {
    public int findMaxK(int[] nums) {
        
        int ans =Integer.MIN_VALUE;
        int i=0;
        int j=0;
        int n= nums.length;
        while( i < n)
        {  
           if( nums[i]*(-1) == nums[j])
           {
            ans= Math.max( ans, nums[i]);
           }
           if( j == n-1)
           {
            j=-1;
            i++;
           }
           j++;
        } 
       return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }
}
