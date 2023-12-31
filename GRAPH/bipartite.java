//bfs
import java.util.*;

class Solution {
    private static final int UNCOLORED = -1;
    private static final int RED = 0;
    private static final int BLUE = 1;

    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            color[i] = UNCOLORED;

            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        for (int a = 0; a < adj.size(); a++) {
            if (color[a] == UNCOLORED) {
                boolean b = bfs(a, color, adj, visited);
                if (!b) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int index, int[] color, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        color[index] = RED;

        while (!q.isEmpty()) {
            int current_node = q.poll();
            int current_node_color = color[current_node];
            visited.add(current_node);

            for (int adjnode : adj.get(current_node)) {
                int adjnodecolor = color[adjnode];

                if (adjnodecolor == current_node_color) {
                    return false;
                } else if (adjnodecolor == UNCOLORED) {
                    color[adjnode] = (current_node_color == RED) ? BLUE : RED;
                    q.offer(adjnode);
                }
            }
        }

        return true;
    }
}



//dfsimport java.util.*;

class Solution
{
    private boolean dfs(int node, int col, int color[], 
    ArrayList<ArrayList<Integer>>adj) {
        
        color[node] = col; 
        
        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj) == false) return false; 
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false; 
            }
        }
        
        return true; 
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
	    for(int i = 0;i<V;i++) color[i] = -1; 
	    
	    // for connected components
	    for(int i = 0;i<V;i++) {
	        if(color[i] == -1) {
	            if(dfs(i, 0, color, adj) == false) return false; 
	        }
	    }
	    return true; 
    }
     public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Solution obj = new Solution();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

}
