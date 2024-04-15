
import java.util.* ;
import java.io.*; 
public class Solution {
static Boolean dp[][];
static int target;
static int size;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        
          target =k;
          size=n;
          dp = new Boolean[n+1][target+1];
          return solve(0,0,arr);
    }
    public static Boolean solve( int currentindex, int currentsum , int [] arr)
    {
        if( currentsum == target)
        return true;
        if( currentindex>=size)
        {
            return false;
        }
        if( currentsum> target)
        return false;
        if( dp[currentindex][currentsum] != null)
        {
            return dp[currentindex][currentsum];
        }  // checking before if currentsum+ next arr value is grtrt than targets, may give tle
        Boolean take = solve( currentindex+1, currentsum+arr[currentindex],arr);
        Boolean skip = solve( currentindex+1, currentsum,arr);

        return dp[currentindex][currentsum] = take||skip;
     
     
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

