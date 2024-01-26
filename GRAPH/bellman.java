//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> edges, int s) {
       
    //   int dist []= new int [v];
       
    //   int err[]= new int[1];
    //   err[0]=-1;
       
    //   Arrays.fill( dist,Integer.MAX_VALUE);
    //   dist[s]=0;
       
    //   for( int i=1;i<=v-1;i++)
    //   {
    //       for( ArrayList<Integer> x:edges)
    //       {
    //           int u = x.get(0);
    //           int vv = x.get(1);
    //           int weight = x.get(2);
               
    //           if(dist[u] != (int)1e9 && weight+dist[u]<dist[vv])
    //           {
    //               dist[vv] = weight+dist[u];
    //           }
    //       }
    //   }
         
         
    //     for( ArrayList<Integer> k: edges)
    //     {
    //         int b = k.get(0);
    //         int a = k.get(1);
    //         int nweight = k.get(2);
            
    //         if( dist[b] !=(int)1e9 && dist[b]+nweight < dist[a])
    //         {
    //         return err;
    //         }
    //     }
        
    //     return dist;
     int dist[] = new int[v];
        Arrays.fill(dist, (int)1e8);
        dist[s] = 0;
        
        int err[] = new int[1];
        err[0] = -1;

        for (int i = 1; i <= v - 1; i++) {
            for (ArrayList<Integer> x : edges) {
                int u = x.get(0);
                int vv = x.get(1);
                int weight = x.get(2);
                
                if (dist[u] != (int)1e8 && weight + dist[u] < dist[vv]) {
                    dist[vv] = weight + dist[u];
                }
            }
        }
         
        for (ArrayList<Integer> k : edges) {
            int b = k.get(0);
            int a = k.get(1);
            int nweight = k.get(2);
            
            if (dist[b] != (int)1e8 && dist[b] + nweight < dist[a]) {
                // Handle negative cycle
                return err;
            }
        }
        
        return dist;
       
    }
}
