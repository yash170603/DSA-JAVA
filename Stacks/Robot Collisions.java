import java.util.*;

public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        Stack<int[]> s = new Stack<>();
        List<int[]> x = new ArrayList<>(); // right ==1, left ==0
        int n = positions.length;
        
        for (int i = 0; i < n; i++) {
            x.add(new int[]{positions[i], healths[i], (directions.charAt(i) == 'R') ? 1 : 0, i});
        }
        Collections.sort(x, (a, b) -> Integer.compare(a[0], b[0]));
      
        for (int[] arr : x) {
            while (!s.isEmpty() && s.peek()[2] == 1 && arr[2] == 0) { // R -> L collision
                int[] top = s.peek();
                if (top[1] > arr[1]) {
                    top[1] -= 1;
                    s.pop();
                    s.push(top);
                    arr[1] = 0; // Current robot is destroyed
                    break;
                } else if (top[1] < arr[1]) {
                    arr[1] -= 1;
                    s.pop();
                } else {
                    s.pop();
                    arr[1] = 0; // Both are destroyed
                    break;
                }
            }
            if (arr[1] > 0) {
                s.push(arr);
            }
        }
        
        List<int[]> d = new ArrayList<>();
        while (!s.isEmpty()) {
            d.add(s.pop());
        }
        
        Collections.sort(d, (a, b) -> Integer.compare(a[3], b[3]));
        
        List<Integer> ans = new ArrayList<>();
        for (int[] p : d) {
            ans.add(p[1]);
        }
        
        return ans;
    }

    
}
