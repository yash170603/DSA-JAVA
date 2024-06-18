import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        // Create a max-heap using a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap by profit

        for (int i = 0; i < n; i++) {
            int diff = difficulty[i];
            int prof = profit[i];
            pq.offer(new int[]{prof, diff});
        }

        // Sort worker array in descending order
        Arrays.sort(worker);
        for (int i = 0; i < worker.length / 2; i++) {
            int temp = worker[i];
            worker[i] = worker[worker.length - 1 - i];
            worker[worker.length - 1 - i] = temp;
        } // isliye reverse mei sort kia bcs ki agar koi task hai jo aage chl kr worker kr skta hai , as in heap top = (50,10)(profit,diff)  and array is 4,5,6,10
           // now if 4 cant do 10 and we remove (50,10) , we are removing a possible task for workeer with capacity 10;
          // thahts why reversed , and if this doens t match ------> line 30
        int i = 0;
        int totalProfit = 0;
        while (i < m && !pq.isEmpty()) {
            if (pq.peek()[1] > worker[i]) {
                pq.poll(); // mai ni kar para toh mujse chota kya krega  <-------- continued after line 25
            } else {
                totalProfit += pq.peek()[0];
                i++;
            }
        }

        return totalProfit;
    }
}
