class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> x = new HashSet<>();
        for( int i:nums)
        {
            x.add(i);
        }
        if(nums.length ==0)
        return 0;
   int max = Integer.MIN_VALUE;
        for( int p : x)
        {
            if( !x.contains(p-1))
            {
                 int  count =1;
                while( x.contains(p+1))
                {
                    count++;
                    p=p+1;
                }
                max = Math.max(max,count);
            }
        }

        return max;
    }
}
