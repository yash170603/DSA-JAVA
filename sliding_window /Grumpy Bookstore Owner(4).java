class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int isum = 0;
              int n = grumpy.length;

       for( int i =0;i<n;i++)
       {
          if( grumpy[i] ==0)
          {
            isum+=customers[i];
          }
       }

        int i=0,j =0;
        int max=0,ws=0,sum=0;

        while( i< n)
        {
            if( grumpy[i] == 1)
            {
                sum+=customers[i];
                
            }
          ws++;
            while( ws> minutes)
            {
                if( grumpy[j]==1)
                {
                    sum-=customers[j];
                    j++;
                    ws--;
                }
                else
                {
                    j++;
                    ws--;
                }
            }

            max= Math.max(max,sum);
            i++;
        }

       return max+isum;
    }
}
