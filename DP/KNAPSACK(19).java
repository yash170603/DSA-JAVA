// gpt
import java.util.Arrays;

public class Solution {
    static int target;
    static int[][] dp;
    static int n;

    static int knapsack(int[] weight, int[] value, int numItems, int maxWeight) {
        target = maxWeight;
        n = numItems;
        dp = new int[n + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, weight, value);
    }

    public static int solve(int currentIndex, int currentWeight, int[] weight, int[] value) {
        if (currentIndex >= n || currentWeight > target) {
            return 0;
        }
        if (dp[currentIndex][currentWeight] != -1) {
            return dp[currentIndex][currentWeight];
        }

        int take = 0;
        if (currentWeight + weight[currentIndex] <= target) {
            take = value[currentIndex] + solve(currentIndex + 1, currentWeight + weight[currentIndex], weight, value);
        }
        int skip = solve(currentIndex + 1, currentWeight, weight, value);

        return dp[currentIndex][currentWeight] = Math.max(take, skip);
    }
 
}


// my code only passed 1 case

import java.util.* ;


import java.io.*; 

public class Solution{
    static int target;
    static int dp[][];
    static int n;
    static int knapsack(int[] weight, int[] value, int N, int maxWeight) {

          target=  maxWeight;
          int totsum =0;
          for( int x: weight)
          {
              totsum +=x;
          }
          n=N;
          dp = new int [n+1][totsum+1];
          for( int arr[]:dp)
          {
              Arrays.fill(arr,-1);
          }

          return solve( 0,0,0,weight,value);

    }

    public static int solve( int currentindex, int currentprice, int currentweight, int [] weight, int [] value)
    {
          
        if( currentindex>= n)
        {
            if( currentweight > target)
            {
                return 0;
            }

            if( currentweight <=target)
            {
                return currentprice;
            }
        }
            if( dp[currentindex][currentweight] != -1)
            {
                return dp[currentindex][currentweight];
            }
            int take = solve( currentindex+1, currentprice+value[currentindex], currentweight+ weight[currentindex], weight, value);
            int skip = solve(currentindex+1, currentprice, currentweight, weight, value);

            return dp[currentindex][currentweight]= Math.max( take, skip);
        
    }

    
}





//unbounded


class Solution{
    static int target;
    static int dp[][];
    static int n;
    static int knapSack(int N, int W, int val[], int wt[])
    {
         target=  W;
          int totsum =0;
          for( int x: wt)
          {
              totsum +=x;
          }
          n=N;
          dp = new int [n+1][target+1];
          for( int arr[]:dp)
          {
              Arrays.fill(arr,-1);
          }

          return solve( 0,0,0,wt,val);
    }
    
     public static int solve( int currentindex, int currentprice, int currentweight, int [] wt, int [] val)
    {
       
         if( currentindex>=n)
            {
                return 0;
            }       
      
            if( dp[currentindex][currentweight] != -1)
            {
                return dp[currentindex][currentweight];
            }
            int take =0;
            if( currentweight+ wt[currentindex]<=target)
            {
  take =val[currentindex]+ solve( currentindex, currentprice+val[currentindex], currentweight+ wt[currentindex], wt, val);
            }
           
            int skip = solve(currentindex+1, currentprice, currentweight, wt, val);

            return dp[currentindex][currentweight]= Math.max( take, skip);
    }
}
