class Solution {
    int n;
    Integer[][] t;

    public int minFlipsMonoIncr(String s) {
        n = s.length();
        t = new Integer[n][2];
        return solve(s, 0, 0);
    }

    public int solve(String s, int currIndex, int prevVal) {
        if (currIndex >= n)
            return 0;

        if (t[currIndex][prevVal] != null)
            return t[currIndex][prevVal];

        int flip = Integer.MAX_VALUE;
        int noFlip = Integer.MAX_VALUE;

        if (s.charAt(currIndex) == '0') {

            if (prevVal == 1) {
                flip = 1 + solve(s, currIndex + 1, 1);
            } else {
                flip = 1 + solve(s, currIndex + 1, 1);
                noFlip = solve(s, currIndex + 1, 0);
            }
        }

        else if (s.charAt(currIndex) == '1') {
            if (prevVal == 1) {
                noFlip = solve(s, currIndex + 1, 1);
            } else {
                flip = 1 + solve(s, currIndex + 1, 0);
                noFlip = solve(s, currIndex + 1, 1);
            }
        }

        return t[currIndex][prevVal] = Math.min(flip, noFlip);
    }
}
