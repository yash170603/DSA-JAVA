import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int a = 0; a < times.length; a++) {
            adj.get(times[a][0] - 1).add(new node(times[a][1], times[a][2]));
        }

        int[] dist = new int[n];
        for (int j = 0; j < n; j++) {
            dist[j] = (int) 1e9;
        }

        dist[k - 1] = 0;
        Queue<node> q = new LinkedList<>();
        q.offer(new node(k, 0));

        while (!q.isEmpty()) {
            int a = q.peek().vertex;
            int b = q.peek().distance;
            node d = q.poll();

            for (node g : adj.get(d.vertex - 1)) {
                int aa = g.vertex;
                int bb = g.distance;
                if (b + bb < dist[aa - 1]) {
                    dist[aa - 1] = b + bb;
                    q.offer(new node(aa, b + bb));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int y = 0; y < n; y++) {
            ans = Math.max(ans, dist[y]);
        }

        return ans == (int) 1e9 ? -1 : ans;
    }
}

class node {
    int vertex;
    int distance;

    node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}
