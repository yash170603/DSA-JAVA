/************************************************************ JAVA ************************************************************/
//Approach-1 (Using Recursion + Memoization)
//T.C : O(n) with memoization, without memoization O(3^n)
//S.C : O(n)
class Solution {
    int M = 1000000007;
    int[][][] t = new int[100001][2][3];

    int solve(int n, int absent, int consecutiveLate) {

        if(absent >= 2 || consecutiveLate >= 3) {
            return 0;
        }

        if(n == 0)
            return 1;
        
        if(t[n][absent][consecutiveLate] != -1) {
            return t[n][absent][consecutiveLate];
        }

        int A = solve(n-1, absent+1, 0) % M;
        int L = solve(n-1, absent, consecutiveLate+1) % M;
        int P = solve(n-1, absent, 0) % M;

        return t[n][absent][consecutiveLate] = ((A + L) % M + P) % M;
    }

    public int checkRecord(int n) {
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }
        return solve(n, 0, 0);
    }
}


//Approach-2 (Using Bottom Up - Xerox of Recursion from Approach-1)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int checkRecord(int n) {
        int M = 1000000007;
        int[][][] t = new int[100001][2][3];

        // Base Case - 0 number of days. So, t[0][A][L], we return 1
        for (int A = 0; A <= 1; ++A) {
            for (int L = 0; L <= 2; ++L) {
                t[0][A][L] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {

                    long result = t[i - 1][A][0];            // P ---> solve(n-1, absent, 0) % M;
                    result += (L < 2 ? t[i - 1][A][L + 1] : 0);  // L ---> solve(n-1, absent, consecutive_late+1) % M;
                    result += (A == 0 ? t[i - 1][A + 1][0] : 0);  // A ---> solve(n-1, absent+1, 0) % M;

                    t[i][A][L] = (int) (result % M);
                }
            }
        }

        return t[n][0][0];
    }
}
