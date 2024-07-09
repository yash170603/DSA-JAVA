class Solution {
    public double averageWaitingTime(int[][] customers) {
        double ans =0;
        double n = customers.length;
        int nft =customers[0][0]+customers[0][1];
        double wt =customers[0][1];
        for( int i =1;i< n;i++)
        {
            int at = customers[i][0];
            int bt = customers[i][1];
            if( at<nft)
            {
                wt+=(nft-at);
            }
            wt+=bt;
            nft= Math.max(nft,at);
            nft+=bt;
        }
      
        ans =  (wt)/n;
        return  ans;
    }
}
