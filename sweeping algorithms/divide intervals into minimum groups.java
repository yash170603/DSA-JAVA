//optimised
import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() < interval[0]) {
                heap.poll();  // Remove the end time of the interval that can be reused
            }

            heap.add(interval[1]);
        }

        return heap.size();
    }
}




//mmy bruteforce
import java.util.*;
class Solution {
    List<int[]> merged;

    public int minGroups(int[][] intervals) {
        merged = new ArrayList<>();
        int ans = 1;
        Arrays.sort(intervals,(a,b)->{
             if(a[0]!=b[0]){
                return a[0]-b[0];
             }
             else return a[1]-b[1];
        });
        for (int arr[] : intervals) {
            if (check(arr))
                ans++;
        }
        return ans;
    }

    public boolean check(int[] arr) {
        if (merged.size() == 0) {
            merged.add(arr);
            return false;
        }
        for (int i = 0; i < merged.size(); i++) {
            int curr[] = merged.get(i);
            if (!intersect(curr, arr)) {
                int[] res = merge(curr, arr);
               
                merged.remove(i);
                merged.add(res);
                return false;
            }
        }
        merged.add(arr);
        return true;
    }

    public boolean intersect(int[] arr1, int[] arr2) {
        if (arr1[1] < arr2[0] || arr2[1] < arr1[0])
            return false;
        return true;
    }

    public int[] merge(int[] arr1, int[] arr2) {
        return new int[] { Math.min(arr1[0], arr2[0]), Math.max(arr1[1], arr2[1]) };
    }
}
