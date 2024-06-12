class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if( (long) m*k > bloomDay.length)
        return -1;
        else
        {
           int min= Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       for( int a: bloomDay)
       {
           max = Math.max(a,max);
           min = Math.min(a,min);
       }
       System.out.println(min);
       System.out.println(max);
     System.out.println(bloomDay.length);

      
         int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible( mid,bloomDay, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    
        }

       
    }


    public boolean possible( int day, int arr[], int bouques, int flowercnt)
    {
        int cnt=0;
        int nob=0;
        for(int x: arr)
        {
            if(x<= day)
            {
                cnt++;
            }

          else if( x> day)
          {
             nob+= cnt/flowercnt;
            cnt=0;
          }
            
            
        }

        nob+= Math.ceil(cnt/flowercnt);
        return (nob>=bouques)?true:false;
    }
}
