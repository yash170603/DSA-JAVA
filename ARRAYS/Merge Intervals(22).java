// correct approach with list of arrays.
class Solution {
    public boolean parseBoolExpr(String expression) {
        return helper(expression, 0, expression.length() - 1);
    }

    private boolean helper(String e, int lo, int hi) {
        if (lo == hi) {
            return e.charAt(lo) == 'f' ? false : true;
        }

        char op = e.charAt(lo);
        boolean res = (op == '|') ? false : true;

        int count = 0;
        for (int i = lo + 1, prev = lo + 2; i <= hi; i++) {
            char c = e.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if ((c == ',' && count == 1) ||
                (c == ')' && count == 0)) {
                boolean next = helper(e, prev, i - 1);

                prev = i + 1;
                if (op == '|') {
                    res |= next;
                } else if (op == '&') {
                    res &= next;
                } else {
                    res = !next;
                }
            }
        }

        return res;
    }
}



// incorrect approach with PQ
/*
reason->
  The second solution using a PriorityQueue doesn't work correctly because a PriorityQueue in Java does not guarantee any particular order when retrieving elements
  , even if you specify a comparator.
  This is because the PriorityQueue is a binary heap, and the order of elements with equal priority (in this case, the start time of the intervals) is not defined.

In the second solution, when you add an interval to the PriorityQueue, 
it may not be added at the end of the queue, but rather at a position that maintains the heap property. 
  This means that when you poll an interval from the queue, it may not be the next interval in the sorted order.
*/


// pq appraoch   tho it passed 51 percent of cases
class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);

       for (int[] interval : intervals) {
            // If the queue is empty or the current interval does not overlap with the previous, add it to the queue
            if (pq.isEmpty() || pq.peek()[1] < interval[0]) {
                pq.add(interval);
            } else {
                // There is an overlap, so we merge the current interval with the previous one
                int[] mergedInterval = pq.poll();
                mergedInterval[1] = Math.max(mergedInterval[1], interval[1]);
                pq.add(mergedInterval);
            }
        }

         // Convert priority queue to array
        int[][] result = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;

    }
}



  
