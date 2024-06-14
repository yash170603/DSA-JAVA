class Solution {
    public int longestOnes(int[] nums, int k) {     
        int i = 0,j =0;
        int n = nums.length;
        int count =0;
        int ans =0;
        int t=k;
        while( i< n)
        {
            if( nums[i] ==1)
            {
                count++;
            }
            else if( nums[i]==0 && t>0)
            {
                count++;
                t--;
            }
      else if( nums[i] ==0 && t ==0)
      {
         while( t == 0)
            {  
                if( nums[j] == 0)
                {
                    t++;
                }
                 count--;
                  j++;
            }
            count++;
            if( nums[i] ==0)
            {
                t--;
            }
      }       
            ans = Math.max( ans,count);
            i++;
        }
       return ans;  
    }
}
