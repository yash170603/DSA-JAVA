class Solution {
    public int[] getOrder(int[][] tasks)
     {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // start time
            sortedTasks[i][1] = tasks[i][1]; // processing time
            sortedTasks[i][2] = i;           // original index
        }

        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]); // Sort by start time

        int[] result = new int[n];
        long currTime = 0;
        int idx = 0;
        int resultIndex = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // Sort by processing time
            } else {
                return a[1] - b[1]; // If equal, sort by original index
            }
        });

        while (idx < n || !pq.isEmpty()) {
            if (pq.isEmpty() && currTime < sortedTasks[idx][0]) {
                currTime = sortedTasks[idx][0];
            }

            while (idx < n && sortedTasks[idx][0] <= currTime) {
                pq.offer(new int[]{sortedTasks[idx][1], sortedTasks[idx][2]});
                idx++;
            }

            int[] currTask = pq.poll();
            currTime += currTask[0];
            result[resultIndex++] = currTask[1];
        }

        return result;
    }
}
