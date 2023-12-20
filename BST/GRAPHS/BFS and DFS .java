// bfs
//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        boolean vis[] = new boolean [v];
        bfs(0,vis,adj,answer);
        return answer;
        
     
    }
    
public void bfs(int node, boolean vis [], ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> answer)
    {
        vis[node] = true;
        answer.add(node);
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(node);

        while(  !q.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            int k = q.poll();
            temp = adj.get(k);
            for( int y : temp)
            {
                if( vis[y] == false)
                {
                    vis[y] = true;
                    answer.add(y);  
                    q.add(y);
                }
            }
        
        }        
    }   
}





// dfs
//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {
       boolean vis[] = new boolean[v];
       
       ArrayList<Integer> answer = new ArrayList<Integer>();
       dfs(0,vis,adj,answer);
       return answer;
       
       
    }
    
    public void dfs (int node, boolean [] vis,ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ans)
    {
        ans.add(node);
        vis[node] = true;
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp = adj.get(node);
        
        for( int u : temp)
        {
            if( vis[u] == false)
            {
                dfs(u,vis,adj,ans);
            }
        }
        
    }
}
