 Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int currentEndTime = Integer.MIN_VALUE;
    int removals = 0;

    for (int i = 0; i < intervals.length; i++) {
        int start = intervals[i][0];
        int end = intervals[i][1];

        if (currentEndTime <= start) {
            currentEndTime = end;
        } else {
            removals++;
        }
    }
    return removals;
