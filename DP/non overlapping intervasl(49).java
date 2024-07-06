public int eraseOverlapIntervals1(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int n = intervals.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return eraseOverlapIntervalsHelp(0, dp, intervals);
}

private int eraseOverlapIntervalsHelp(int index, int[] dp, int[][] intervals) {
    if (index == intervals.length) return 0;
    if (dp[index] != -1) return dp[index];

    int lb = findLowerBound(intervals[index][1], index + 1, intervals);
    int takeCurrent = eraseOverlapIntervalsHelp(lb, dp, intervals) + (lb - index - 1);
    int skipCurrent = eraseOverlapIntervalsHelp(index + 1, dp, intervals) + 1;
    return dp[index] = Math.min(takeCurrent, skipCurrent);
}

private int findLowerBound(int x, int start, int[][] intervals) {
    int left = start, right = intervals.length - 1, lowerBound = intervals.length;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (intervals[mid][0] < x) {
            left = mid + 1;
        } else {
            lowerBound = mid;
            right = mid - 1;
        }
    }
    return lowerBound;
}


//bottom up


public int eraseOverlapIntervals2(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int n = intervals.length;
    int[] dp = new int[n + 1];

    for (int index = n - 1; index >= 0; index--) {
        int lb = findLowerBound(intervals[index][1], index + 1, intervals);
        int takeCurrent = dp[lb] + (lb - index - 1);
        int skipCurrent = dp[index + 1] + 1;
        dp[index] = Math.min(takeCurrent, skipCurrent);
    }
    return dp[0];
}
