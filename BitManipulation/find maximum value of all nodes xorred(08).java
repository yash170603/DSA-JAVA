class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) 
    {
       long ans=0;
       int count =0;
       long nuksan=Integer.MAX_VALUE;

       for( int i:nums)
       {
        if( (i^k) >i)
        {
            ans+=(i^k);
            count ++;
        }
        else
        {
            ans+=i;
        }

        nuksan = (long)Math.min(nuksan, Math.abs(i-(i^k)));
       }

       if(count%2==0)
       return ans;

       return ans-nuksan;


    }
}
