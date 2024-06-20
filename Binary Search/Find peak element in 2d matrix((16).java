class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        int low= 0;
        int high = m-1;
        while( low<=high )
        {
            int coli= (low+high)/2;
            int maxi = find( coli, mat, n);
            int left = ( coli-1>=0)?mat[maxi][coli-1]:-1;
            int right = (coli+1<m)?mat[maxi][coli+1]:-1;
            if( mat[maxi][coli] > left && mat[maxi][coli]>right)
            {
                return new int[]{maxi,coli};
            }
            if( mat[maxi][coli]<left)
            {
                high= coli-1;
            }
            else
            low=  coli+1;
        }
        return new int []{-1,-1};  
    }
    public int find( int colindex, int [][] arr,int n)
    {
        int max = 0 ;
        int ele= arr[0][colindex];
        for( int i=1;i<n;i++)
        {
             if( arr[i][colindex]> ele)
             {
                ele=arr[i][colindex];
                max=i;
             }
        }
        return max;
    }
}
