import java.util.*;
// a good one
class Solution {
    public int slidingPuzzle(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s.append(board[i][j]);
            }
        }

        String exp = "123450"; // Target state
        Queue<String> q = new LinkedList<>();
        q.add(s.toString());
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(1, 3));
        map.put(1, Arrays.asList(0, 2, 4));
        map.put(2, Arrays.asList(1, 5));
        map.put(3, Arrays.asList(0, 4));
        map.put(4, Arrays.asList(1, 3, 5));
        map.put(5, Arrays.asList(2, 4));

        HashSet<String> set = new HashSet<>();
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();  
            for (int k = 0; k < size; k++) {
                String curr = q.poll();
                if (set.contains(curr)) continue;
                set.add(curr);
                if (curr.equals(exp)) return ans;

                int thisIndex = curr.indexOf('0');
                List<Integer> x = map.get(thisIndex);
                for (int i : x) {
                    StringBuilder temp = new StringBuilder(curr);
                    char ch = temp.charAt(i);
                    temp.setCharAt(i, curr.charAt(thisIndex));
                    temp.setCharAt(thisIndex, ch);
                    q.add(temp.toString());
                }
            }
            ans++;
        }

        return -1;  
    }
}
