class Solution {
    public int maxSubArray(int[] nums) {
        
        int max  = Integer.MIN_VALUE;
        int cursum =0;
        int n = nums.length;
      int i =0;
        while(i<n)
        {
            cursum +=nums[i];
            
            max = Math.max(max,cursum);


            if( cursum <0)
            {
                cursum =0;
            }
           i ++;
        }

        return max;
    }
}

// jist
har bas sum calculate kro
  nae sum ko max se compare kr update kro
  if( sum) is <0 sum ==0; negative sum ko aage le jane ka koi fayda nahi hai.
  return max;
