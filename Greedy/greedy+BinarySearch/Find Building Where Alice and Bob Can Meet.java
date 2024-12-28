import java.util.*;

class Solution {
    public int binarySearch(int height, List<int[]> st) {
        int l = 0, r = st.size() - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (st.get(mid)[0] > height) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<int[]> st = new ArrayList<>();
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);

        List<List<int[]>> newQueries = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            answer[i] = (heights[b] > heights[a] || a == b) ? b : -1;
            if (answer[i] == -1) {
                newQueries.get(b).add(new int[]{heights[a], i});
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            for (int[] query : newQueries.get(i)) {
                int h = query[0], idx = query[1];
                int pos = binarySearch(h, st);
                if (pos != -1) {
                    answer[idx] = st.get(pos)[1];
                }
            }
            while (!st.isEmpty() && st.get(st.size() - 1)[0] <= heights[i]) {
                st.remove(st.size() - 1);
            }
            st.add(new int[]{heights[i], i});
        }

        return answer;
    }
}
