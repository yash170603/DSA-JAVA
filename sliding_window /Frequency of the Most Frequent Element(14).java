class Solution {
    public int maxFrequency(int[] nums, int kk) {
        
        Arrays.sort(nums);
        long n = nums.length;
        long l=0,r=0;
        long max=0, total=0,k=kk;

        while(r<n)
        {
           total+=nums[(int)r];
           while( (long)((r-l+1)*nums[(int)r])> total+k )
           {
            total-=nums[(int)l];
            l++;
           }
           max=Math.max( (r-l+1),max);
           r++;
        }
        return (int)max;

    }
}
