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
