class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        double [] p= new double[n+1];
        Arrays.fill(p,0.0);


        p[0]=1.0;
       

       for( int  sum = 1; sum <=n;sum++){
        for( int card = 1 ; card <= maxPts;card++){
            if(sum-card>=0 && sum-card<k)
            p[sum] += p[sum-card]/maxPts;
        }
       }
      
       double ans=0.0;
        for( int s= k;s<=n;s++){
            ans+=p[s];
        }

        return ans;



    }
}

optimal 
  class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        double [] p= new double[n+1];
        Arrays.fill(p,0.0);


        p[0]=1.0;
        double cp = (k==0)?0:1;

        for( int sum=1; sum<=n;sum++){
            p[sum]= cp/maxPts;

            if(sum<k){
                cp+=p[sum];
            }

            if( sum-maxPts>=0 &&  sum-maxPts<k){
                cp-=p[sum-maxPts];
            }
        }
       double ans=0.0;
        for( int s= k;s<=n;s++){
            ans+=p[s];
        }

        return ans;
    }
}
