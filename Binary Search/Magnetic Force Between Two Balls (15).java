class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int n = position.length;
        int min =0;
        int max= position[n-1]-position[0];
        int low= min;
        int high= max;
         int ans=low;
        while( low<=high)
        {
            int mid = (low+high)/2;

            if( possible(mid,position,m)==true)
            {  ans=mid;
                low= mid+1;
            }
            else
            {
                high= mid-1;
            }
        }

        return ans;
       
    }


    public boolean possible( int distance, int []arr, int balls)
    {
        int n= arr.length;
        int cnt=1;
        int pindex=0; //prev index
        for( int i=1;i<n;i++)
        {
            if( arr[i]-arr[pindex] >= distance)
            {
                cnt++;
                pindex=i;
            }
            if( cnt== balls)
            return true;
        }
        return false;
    }
}
