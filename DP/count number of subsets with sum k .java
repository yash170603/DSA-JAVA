// simple recusrion 26/50

import java.util.*;

public class Solution {
    static int ans;
    static int target;
    static int n;
    public static int findWays(int num[], int tar) {
        
        ans=0;
        target = tar;
        n = num.length;

        solve(0,0,num);
        return ans;



    }

    public static void solve( int currentindex, int currentsum, int [] arr)
    {
        if( currentsum == target)
        {
            ans++;
            return;
        }

        if(currentindex>=n)
        return;

        solve(currentindex+1,currentsum,arr); 
        solve(currentindex+1, currentsum+arr[currentindex],arr);


      /* if( currentsum+arr[currentindex]<=target)
       {
            solve(currentindex+1, currentsum+arr[currentindex],arr);
       }
        solve(currentindex+1,currentsum,arr);   this passes 30/50*/
    }

}



// recusrion with memo
import java.util.*;

public class Solution {
    static int ans;
    static int target;
    static int n;
    static int dp[][];
    static  int mod =1000000007;
    public static int findWays(int num[], int tar) {
        
       // ans=0;
       Arrays.sort( num);  // impotant
        target = tar;
        n = num.length;
        dp = new int[n+1][target+1];
        for(int a[]:dp)
        {
            Arrays.fill(a,-1);
        }
         return solve(0,0,num);
         //ans;
    }

    public static int solve( int currentindex, int currentsum, int [] arr)
    {
           if(currentindex<n)
        {
           if(currentsum == target && arr[currentindex] ==0 )
            return 2;
                //    if ((currentSum == target && arr[currentIndex] == 0) ||(currentSum == target && arr[currentIndex] == target) )
                // this second condiiton doesnt work ,idk why
        }  // special case when arr[i] can be zeroo
         
        if( currentsum == target)
        {
            return 1 ;
        }

        if(currentindex>=n || currentsum>target)
        return 0;
        if( dp[currentindex][currentsum] !=-1)
        {
            return dp[currentindex][currentsum];
     
        }
          int   take=   solve(currentindex+1, currentsum+arr[currentindex],arr)%mod;
          int skip= solve(currentindex+1,currentsum,arr)%mod;

          return dp[currentindex][currentsum]= (take+skip) %mod;
       
    }

}

