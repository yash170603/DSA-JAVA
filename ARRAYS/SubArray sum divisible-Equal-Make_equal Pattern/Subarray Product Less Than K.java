class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int n= nums.length;
     int j =0;
     int i=0;
     int prod =1;
     int result=0;
    
    if(k<=1)
    {
        return 0;
    }
     while( j<n)
     {
        prod *= nums[j];
        while(prod >=k)
        {
            prod /=nums[i];
            i++;
        }

        result += (j-i+1);
        j++;
     }

     return result;
    }
}
