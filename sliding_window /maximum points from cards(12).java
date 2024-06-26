class Solution {
    public int maxScore(int[] cp, int k) {
        
        int left=0,n= cp.length,right= n-k;
        int outersum= 0,max=Integer.MIN_VALUE;
        for( int i = right;i<n;i++)
        {
            outersum+=cp[i];
        }
          max=outersum;
        while( right<n)
        {
            outersum = (outersum-cp[right])+cp[left];
            max= Math.max(max,outersum);
            left++;
            right++;
        }
        return max;
        

    }
}
