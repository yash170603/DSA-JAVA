class Solution {
    public long countSubarrays(int[] nums, int mink, int maxk) {
        
        long mini =-1;
        long maxi = -1;
        long badi=-1;
        long ans=0;

        for(long i=0;i<nums.length;i++)
        {

            if(nums[(int)i] == mink)
            {
                mini =i;
                
            }
             if(nums[(int)i] == maxk)
            {
                maxi =i;
                
            }
             if(nums[(int)i] >maxk || nums[(int)i]<mink)
            {
                badi =i;
            }

            ans += Math.max(0,Math.min(mini,maxi)-badi);

        }

        return ans;
    }
}
