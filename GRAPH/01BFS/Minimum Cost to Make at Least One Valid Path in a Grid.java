import java.util.*; // dikjstra

class Solution {
    public int minCost(int[][] grid) {
        // Corrected Direction Mapping
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0, 1});  // Right
        map.put(2, new int[]{0, -1}); // Left
        map.put(3, new int[]{1, 0});  // Down
        map.put(4, new int[]{-1, 0}); // Up

        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m]; 
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
 
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x, y = curr.y, cost = curr.cost;

            // If we reach the destination, return immediately , and this is also what 
            if (x == n - 1 && y == m - 1) return cost;

            // If already visited with a smaller cost, skip
            if (vis[x][y] == 1) continue;
            vis[x][y] = 1;   // this is what i was missing,  

           
            int[] req = map.get(grid[x][y]);
            int nx = x + req[0], ny = y + req[1];  // kidhar jana chahata hoon, jaane do 
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && vis[nx][ny] == 0) {
                pq.offer(new Node(nx, ny, cost)); 
            }
 
            for (int i = 1; i <= 4; i++) {   // nahi jaa skta toh, cost lagega 
                if (i == grid[x][y]) continue;  

                int[] req2 = map.get(i);
                int nnx = x + req2[0], nny = y + req2[1];

                if (nnx >= 0 && nnx < n && nny >= 0 && nny < m && vis[nnx][nny] == 0) {
                    pq.offer(new Node(nnx, nny, cost + 1));  
                }
            }
        }

        return -1; 
    }
}

 
class Node {
    int x, y, cost;
    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}



// 01 bfs dequq
import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        // Corrected Direction Mapping
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0, 1});  // Right
        map.put(2, new int[]{0, -1}); // Left
        map.put(3, new int[]{1, 0});  // Down
        map.put(4, new int[]{-1, 0}); // Up

        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m]; // Visited array
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
 
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x, y = curr.y, cost = curr.cost;

            // If we reach the destination, return immediately , and this is also what 
            if (x == n - 1 && y == m - 1) return cost;

            // If already visited with a smaller cost, skip
            if (vis[x][y] == 1) continue;
            vis[x][y] = 1;   // this is what i was missing,  

           
            int[] req = map.get(grid[x][y]);
            int nx = x + req[0], ny = y + req[1];  // kidhar jana chahata hoon, jaane do 
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && vis[nx][ny] == 0) {
                pq.offer(new Node(nx, ny, cost)); 
            }
 
            for (int i = 1; i <= 4; i++) {   // nahi jaa skta toh, cost lagega 
                if (i == grid[x][y]) continue;  

                int[] req2 = map.get(i);
                int nnx = x + req2[0], nny = y + req2[1];

                if (nnx >= 0 && nnx < n && nny >= 0 && nny < m && vis[nnx][nny] == 0) {
                    pq.offer(new Node(nnx, nny, cost + 1));  
                }
            }
        }

        return -1; 
    }
}

 
class Node {
    int x, y, cost;
    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
