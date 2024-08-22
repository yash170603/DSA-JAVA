import java.util.*;

class Solution {
    private int n;
    private int[][] t;

    private int solve(int l, int r, String s) {
        if (l == r) {
            return 1;
        } else if (l > r) {
            return 0;
        }

        if (t[l][r] != -1) {
            return t[l][r];
        }

        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }

        if (i == r + 1) {
            return 1;
        }

        int normal = 1 + solve(i, r, s);
        int aageKa = Integer.MAX_VALUE;

        for (int j = i; j <= r; j++) {
            if (s.charAt(l) == s.charAt(j)) {
                int x =  solve(i, j - 1, s) + solve(j, r, s);
                aageKa = Math.min(aageKa, x); 
            }
        }

        return t[l][r] = Math.min(aageKa, normal);
    }

    public int strangePrinter(String s) {
        n = s.length();
        t = new int[n][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, s);
    }
}

   
