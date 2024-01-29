//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int v, int e, int edges[][])
	{
	    int sum=0;
	    boolean inmst[]=new boolean[v];
	    
	    ArrayList<ArrayList<node>> adj = new ArrayList<>();
	    for( int j=0;j<v;j++)
	    {
	        adj.add(new ArrayList<>());
	    }
	    for( int i=0;i< edges.length;i++)
	    {
	        int head =edges[i][0];
	        int child=edges[i][1];
	        int weight=edges[i][2];
	        adj.get(head).add( new node ( weight,child));
	        adj.get(child).add( new node ( weight,head));
	    }
	    PriorityQueue<node> q = new PriorityQueue<>((x,y) -> x.wgh - y.wgh);
	    q.offer( new node ( 0,0));
	    
	    while( !q.isEmpty())
	    {
	        node d = q.poll();
	        int weigh = d.wgh;
	        int chd = d.chl;
	        if( inmst[chd] == true)
	        continue; // pq toh node nikalega hi, par vo pehle kam weight wala edge nikal hi dega, and and agr vo vertex dubara aaega mtlb heavy hoga, so ignore 
	        
	        inmst[chd]=true;
	        sum+=weigh;
	        
	        for( node g : adj.get(chd))
	        {
	            int a = g.wgh;
	            int b= g.chl;
	            
	            if( inmst[b] == false)
	            {
	                q.offer( new node ( a,b));
	            }
	        }
	        
	    }
	    
	    return sum;
	    
	     
	}
}
class node
{
    int wgh;
    int chl;
    
    node( int wgh, int chl)
    {
        this.wgh= wgh;
        this.chl = chl;
    }
    
}

/*The loop to construct the adjacency list runs in O(E) time because it iterates through all the edges once.
Since each edge is added and polled at most once from the priority queue, the overall time complexity for these operations is O(E * log E).

Overall Time Complexity: Combining the time complexities of constructing the adjacency list and priority queue operations, the overall time complexity is O((V + E) * log E).

Therefore, the time complexity of the given code is O((V + E) * log E).*/
