//brute force
import java.util.*;
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] qq) {
        
        HashMap<Integer,List<node> > map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.putIfAbsent(i,new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            node curr = new node(i+1,1);
            map.get(i).add(curr);
        }
        int  [] ans = new int[qq.length];
        for(int j=0;j<qq.length;j++){
            int src = qq[j][0];
            int dest = qq[j][1];
            map.get(src).add( new node(dest,1));
            ans[j] = bfs(map,0,n-1);
        }
        return ans;
    }

    public int bfs( HashMap<Integer, List<node>> map, int src, int dest){
         
         int [] dist = new int[map.size()];
         Arrays.fill(dist,Integer.MAX_VALUE);
         dist[src]=0;
         PriorityQueue<node> pq= new PriorityQueue<>((a,b)->(a.dis-b.dis));
         pq.offer( new node(src,0));

         while( ! pq.isEmpty()){
              node currNode = pq.poll();
              int  parent = currNode.prnt;
              int distance = currNode.dis;

              List<node> kids = map.get( parent);
              for( node  kid: kids){
                    int kidNode = kid.prnt;
                    int kidDis = kid.dis;
                    if( dist[kidNode] > distance + kidDis){
                        dist[kidNode] = distance + kidDis;
                        pq.offer( new node(kidNode,dist[kidNode]));
                    }
              }
         }
         return dist[dest];
    }
}

class node{
    int  prnt;
    int dis;
    node( int prnt, int dis){
        this.prnt =prnt;
        this.dis=dis;
    }
}



// awsome optimization
// like bhosde khol diye dimaag k
import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] qq) {
        // Build initial adjacency list for the graph
        HashMap<Integer, List<Node>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            map.get(i).add(new Node(i + 1, 1));
        }

        // Precompute the shortest distances initially
        int[] dist = dijkstra(map, 0, n);

        // Array to store results
        int[] ans = new int[qq.length];
        
        // Process each query
        for (int j = 0; j < qq.length; j++) {
            int src = qq[j][0];
            int dest = qq[j][1];

            // Add new edge to the graph
            map.get(src).add(new Node(dest, 1));

            // Update only the affected parts of the shortest distances
            dist = updateShortestPath(map, dist, src, dest, n);

            // Record the shortest distance from 0 to n-1 after the query
            ans[j] = dist[n - 1];
        }

        return ans;
    }

    // Initial Dijkstra to compute shortest distances from the source
    public int[] dijkstra(HashMap<Integer, List<Node>> map, int src, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.dis - b.dis));
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int parent = currNode.prnt;
            int distance = currNode.dis;

            for (Node neighbor : map.getOrDefault(parent, new ArrayList<>())) {
                if (dist[neighbor.prnt] > distance + neighbor.dis) {
                    dist[neighbor.prnt] = distance + neighbor.dis;
                    pq.offer(new Node(neighbor.prnt, dist[neighbor.prnt]));
                }
            }
        }

        return dist;
    }

    // Update shortest path dynamically after adding a new edge
    public int[] updateShortestPath(HashMap<Integer, List<Node>> map, int[] dist, int src, int dest, int n) {
        // If the newly added edge improves the shortest path, propagate the changes
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.dis - b.dis));

        // Add the new edge to the queue if it reduces the distance
        if (dist[dest] > dist[src] + 1) {
            dist[dest] = dist[src] + 1;
            pq.offer(new Node(dest, dist[dest]));
        }

        // Propagate changes for affected nodes
        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int parent = currNode.prnt;
            int distance = currNode.dis;

            for (Node neighbor : map.getOrDefault(parent, new ArrayList<>())) {
                if (dist[neighbor.prnt] > distance + neighbor.dis) {
                    dist[neighbor.prnt] = distance + neighbor.dis;
                    pq.offer(new Node(neighbor.prnt, dist[neighbor.prnt]));
                }
            }
        }

        return dist;
    }
}

class Node {
    int prnt;
    int dis;

    Node(int prnt, int dis) {
        this.prnt = prnt;
        this.dis = dis;
    }
}
