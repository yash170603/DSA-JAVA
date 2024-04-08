class Solution{
 static int n;
    static int t;
    static int[][] dp;


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
         n = N;
        t = sum;
        dp = new int[n][t + 1];
        for (int[] ass : dp) {
            Arrays.fill(ass, -1);
        }

        return solve(0, 0, arr);
    }
    
     public static Boolean solve(int currentindex, int currentsum, int[] arr) {
        if (currentindex >= n) {
            if (currentsum == t)
                return true;

            return false;
        }
            if(currentsum > t)
            {
                return false;
            }
        if (dp[currentindex][currentsum]!= -1) {
            return dp[currentindex][currentsum] == 1;
        }

        Boolean ignorecurr = solve(currentindex + 1, currentsum, arr);

        Boolean tookcurr = solve(currentindex + 1, currentsum + arr[currentindex], arr);

        Boolean ans = tookcurr || ignorecurr;

        dp[currentindex][currentsum] = (ans == true? 1 : 0);

        return ans;
    }
}




// bottom up

class Solution{
 static boolean dp[][];

    static Boolean isSubsetSum(int N, int arr[], int sum){
      
      dp= new boolean [N+1][sum+1];
      
      
      for( boolean arrr [] : dp)
      Arrays.fill(arrr,false);
      
      for( int i=0;i<N+1;i++)
      {
          for( int j=0;j<sum+1;j++)
          {
              
              if(i ==0 && j==0)
              {
                  dp[i][j]=true;
              }
              else  if( i == 0 )
              {
                  dp[i][j] = false;
                  
              }
              else   if( j ==0)
              {
                  dp[i][j]= true;
              }
               else
               {
                   if( dp[i-1][j] == true)
                   {
                       dp[i][j]= true;
                   }
                   
                   else
                   {
                         int val = arr[i-1];
                         if( j>=val)
                         {
                             if( dp[i-1][j-val] == true)
                             {  // bachi hui team kya bache hue run bana paa rahi??
                                // i wrote dp[i][j-val] but doesnt work idkwy
                              // as if bachi team had made runs in orev row, it must have made same runs in my row
                                 dp[i][j] = true;
                             }
                         }
                   }
               }
              
          }
      }
      
      
      return dp[N][sum];
      
    }
}

