class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long right = 0; 
        long left = 0; 

        // Calculate the maximum time required
        for (int time : workerTimes) {
            right = Math.max(right, (long) time * mountainHeight * (mountainHeight + 1) / 2);
        }

        while (left < right) {
            long midTimeAllocated = left + (right - left) / 2;

            if (solve(midTimeAllocated, mountainHeight, workerTimes)) {
                right = midTimeAllocated; // Move left if we can reduce height in time
            } else {
                left = midTimeAllocated + 1; // Increase time if not possible
            }
        }

        return left; // left will be the minimum time required
    }

    public boolean solve(long allocatedTime, int mountainHeight, int[] workerTimes) {
        long maxHeight = 0;

        for (int person : workerTimes) {
            long left = 0;
            long thisAnswer = 0;
            long right = mountainHeight;

            while (left <= right) {
                long midHeightAlloted = left + (right - left) / 2;
                long timeTakenForThisPerson = (long) person * midHeightAlloted * (midHeightAlloted + 1) / 2; // Time for the selected mid height

                if (timeTakenForThisPerson <= allocatedTime) {
                    thisAnswer = midHeightAlloted; // Possible to reduce this much height
                    left = midHeightAlloted + 1; // Try for more height
                } else {
                    right = midHeightAlloted - 1; // Try for less height
                }
            }
            
            maxHeight += thisAnswer;
            if (maxHeight >= mountainHeight) return true; // If we have reduced enough height
        }

        return false; // Not enough height reduced
    }
}
