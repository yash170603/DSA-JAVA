//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges)
	{ List<List<pair>> adj = new ArrayList<>();
	    for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
	    
	    for( int j =0;j< M;j++)
	    {
	        int  head =edges[j][0];
	        int nodes = edges[j][1];
	        int weight= edges[j][2];
	        adj.get(head).add( new pair( nodes, weight));
	    }
	    int vis[] = new int[N];
	    Stack<Integer> s = new Stack<>();
	    for( int h =0;h<N;h++)
	    {
	        if( vis[h] == 0)
	        {
	            toposort( h,vis,s,adj);
	        }
	    }
	    
	    int dist[] = new int [N];
	    for( int p =0;p<N;p++) dist[p] = (int)1e9;
	    dist[0] =0;
	    
	    while( !s.isEmpty())
	    {
	         int node = s.peek();
      s.pop();

      for (int i = 0; i < adj.get(node).size(); i++) {
        int v = adj.get(node).get(i).nodes;
        int wt = adj.get(node).get(i).weight;

        if (dist[node] + wt < dist[v]) {
          dist[v] = wt + dist[node];
        }
      }
	    }
	      
	      for (int i = 0; i < N; i++) {
      if (dist[i] == 1e9) dist[i] = -1;
    }
    return dist;
	    

	}
public void toposort( int node, int [] vis, Stack<Integer> s, List<List<pair>> adj)
	{
	    vis[node] =1;
	    
	    for( pair x: adj.get(node))
	    {
	        int xx = x.nodes;
	        if(vis[xx] == 0)
	        toposort(xx, vis,s,adj);
	    }
	    
	    s.push(node);
	}
}
class pair
{
    int nodes;
    int weight;
    pair( int nodes, int weight)
    {
        this.nodes = nodes;
        this.weight = weight;
    }
}
