//top down
class Solution {
    int dp[][];
    int n;
    public int minSteps(int nn) {
       if(nn==1)
       return 0;
       //if
        n=nn;
        dp= new int[n+1][n+1];
        for( int arr[]:dp){
            Arrays.fill(arr,-1);
        }
      
      return 1+solve(1,1);

    }


    public int solve( int currentA, int copiedA ){
        if( currentA==n){
            return 0;
        }

        if(currentA>n)return 9999;

        if( dp[currentA][copiedA]!=-1){
            return dp[currentA][copiedA];
        }

        int copyPaste= 2+ solve( currentA+currentA, currentA);
        int paste= 1+ solve(currentA+copiedA,copiedA);
        return dp[currentA][copiedA]=Math.min(copyPaste,paste);

    }
}



//bottom up
class Solution {
    public int minSteps(int n) {
        if(n==1)
        return 0;
        int dp[]= new int [n+1] ;
            Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=0;
        dp[2]=2;
        for( int i=3;i<=n;i++){
            int factor_from_last=i/2;
            while(factor_from_last>=0){
                if( i%factor_from_last ==0)
                {
                      int a= dp[factor_from_last];
                      int b=1;
                      int c= (i/factor_from_last)-1;
                      dp[i]=a+b+c;
                      break;
                }
                factor_from_last--;
            }
            
        }

        return dp[n];
    }
}
