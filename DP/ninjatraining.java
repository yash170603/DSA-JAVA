//dfs passed10/11 cases
import java.util.Arrays;
public class Solution {
    static int dp[][];
    public static int ninjaTraining(int n, int points[][]) {

       dp = new int [n][3];
       for( int arr[]:dp)
       {
           Arrays.fill(arr,-1);
       }
       
       int ans=0;
       for(int i=0;i<3;i++)
       {
           ans= Math.max(ans, solve(0,i,-1,n,points));
       }
       return ans;
    }

    public static int solve( int today, int todayactivity, int prevactivity,int n, int [][] points)
    {
       
       if(today>=n)
       {
           return 0;
       }

       if( dp[today][todayactivity] != -1)
       {
           return dp[today][todayactivity];
       }
   
   int answer=0;

         for( int i=0;i<3;i++)
         {
             if( i != todayactivity)
             {
                   answer = Math.max(answer, solve(today+1,i,todayactivity,n,points)) ;
             }
         }

         dp[today][todayactivity] = answer+ points[today][todayactivity];

         return          dp[today][todayactivity];

    }

}

//t.c-The time complexity of the given solution is O(n^3). This is because there are three nested loops: the outer loop iterates over the three activities (0, 1, 2), 
//the middle loop iterates over the three activities again, and the innermost loop recursively calls the solve function.
//The space complexity of the solution is O(n^2), which is the size of the dp array.


//bottom up
  public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
 int[][] dp = new int[n][3];

        // Base case: The maximum merit points for the first day is the same as the points earned on that day
        for (int i = 0; i < 3; i++) {
            dp[0][i] = points[0][i];
        }

        // Iterating over the days starting from the second day
        for (int day = 1; day < n; day++) {
            // For each activity on the current day, finding the maximum merit points
            for (int activity = 0; activity < 3; activity++) {
                // Initializing the maximum merit points for the current activity on the current day
                dp[day][activity] = 0;
                // For each activity on the previous day
                for (int prevActivity = 0; prevActivity < 3; prevActivity++) {
                    // If the previous activity is different from the current activity
                    if (prevActivity != activity) {
                        // Updating the maximum merit points for the current activity on the current day
                        dp[day][activity] = Math.max(dp[day][activity], dp[day - 1][prevActivity] + points[day][activity]);
                    }
                }
            }
        }

        // Finding the maximum merit points over all activities on the last day
        int maxMerit = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));

        return maxMerit;
        // Write your code here..
    }

}
