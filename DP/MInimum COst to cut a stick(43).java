//botom up
class Solution {
    public int minCost(int n, int[] cuts) {
           var c = new ArrayList<Integer>();
    for (int cut : cuts)
        c.add(cut);
    c.addAll(Arrays.asList(0, n));
    Collections.sort(c);
    int[][] dp = new int[c.size()][c.size()];
    for (int i = c.size() - 1; i >= 0; --i)
        for (int j = i + 1; j < c.size(); ++j) {
            for (int k = i + 1; k < j; ++k)
                dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                    c.get(j) - c.get(i) + dp[i][k] + dp[k][j]);
        }
    return dp[0][c.size() - 1];  
    }
}


// top down
class Solution {
    public int[][] dp;

    public int minCost(int n, int[] cuts) {
          int m = cuts.length;
        int[] extendedCuts = new int[m + 2];
        extendedCuts[0] = 0;
        extendedCuts[m + 1] = n;
        System.arraycopy(cuts, 0, extendedCuts, 1, m);
        Arrays.sort(extendedCuts);
        dp = new int[m + 2][m + 2];
        return dfs(extendedCuts, 0, m + 1);
    }

    public int dfs(int[] cuts, int i, int j) {
        if (j - i <= 1) {
            return 0;
        }
        if (dp[i][j] == 0) {
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; ++k) {
                dp[i][j] = Math.min(dp[i][j], cuts[j] - cuts[i] + dfs(cuts, i, k) + dfs(cuts, k, j));
            }
        }
        return dp[i][j];
    }
}
