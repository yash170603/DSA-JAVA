uisng dijkstras 
  import java.util.*;
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        // Build the adjacency list
        for (int i = 0; i < changed.length; i++) {
            int first = original[i] - 'a';
            int second = changed[i] - 'a';
            
            adj.putIfAbsent(first, new ArrayList<>());
            adj.putIfAbsent(second, new ArrayList<>());
            
            adj.get(first).add(new int[]{second, cost[i]});
           // adj.get(second).add(new int[]{first, cost[i]});
        }
        
        // Map to store the shortest distance from each node to every other node
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int j = 0; j < 26; j++) {
            int[] dist = new int[26];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[j] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{j, 0});
            
            while (!pq.isEmpty()) {
                int[] polled = pq.poll();
                int node = polled[0];
                int dis = polled[1];
                
                for (int[] x : adj.getOrDefault(node, new ArrayList<>())) {
                    int neigh = x[0];
                    int weight = x[1];
                    
                    if (dis + weight < dist[neigh]) {
                        dist[neigh] = dis + weight;
                        pq.offer(new int[]{neigh, dist[neigh]});
                    }
                }
            }
            
            // // Store the shortest distances from node j to all other nodes in the map
            // List<Integer> distanceList = new ArrayList<>();
            // for (int k = 0; k < 26; k++) {
            //     distanceList.add(dist[k]);
            // }
            // map.put(j, distanceList);
            map.putIfAbsent(j,new ArrayList<>());
            for( int k: dist){
            map.get(j).add(k);
    }

        }
        
        long ans = 0;
        for (int u = 0; u < source.length(); u++) {
            int from = source.charAt(u) - 'a';
            int to = target.charAt(u) - 'a';
            
            if (map.get(from).get(to) == Integer.MAX_VALUE) {
                return -1; // Return -1 if transformation is not possible
            }
            
            ans += map.get(from).get(to);
        }
        
        return ans;
    }

}




//using floyd warhall
import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }
        
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dis[from][to] = Math.min(dis[from][to], cost[i]);
        }
        
        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
        }
        
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (dis[from][to] == Integer.MAX_VALUE) {
                return -1;
            }
            ans += dis[from][to];
        }
        
        return ans;
    }
}
