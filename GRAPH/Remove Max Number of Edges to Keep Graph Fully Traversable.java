class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

             Arrays.sort(edges, (a,b)->b[0]-a[0]);
             int bobedge=0,aliceedge=0,removededge=0;
            DSU alice = new DSU(n);
            DSU bob= new DSU(n);

             for( int arr[]:edges)
             {
                if( arr[0] == 3)
                {
                    if(  alice.find(arr[1]) !=  alice.find( arr[2]) )
                    {
                        alice.union(arr[1],arr[2]);
                        bob.union(arr[1],arr[2]);
                        aliceedge++;
                        bobedge++;
                    }
                    else
                    removededge++;
                }
                else if( arr[0] ==1) // only alice
                {
                    if( alice.find(arr[1]) !=  alice.find( arr[2]))
                    {
                         alice.union(arr[1],arr[2]);
                        aliceedge++;
                    }
                    else
                    removededge++;

                }
                else if( arr[0] ==2)
                {
                     if( bob.find(arr[1]) !=  bob.find( arr[2]))
                    {
                         bob.union(arr[1],arr[2]);
                        bobedge++;
                    }
                    else
                    removededge++;
                }
             }
         
        return ( bobedge==n-1 && aliceedge==n-1)?removededge:-1;
        
    }
}


 public class DSU {
    private int[] parent;
    private int[] rank;

    // if we had to do this with size comparison, defins=e size array instead of rank

    // Constructor to initialize DSU with 'n' elements
    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];

        // Initially, each element is its own parent, and rank is 0.
        for (int i = 1; i <n+1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find operation with path compression
    public int find(int x) {
        if (parent[x] == x) {
            return  x ;
        }
        int a  = find(parent[x]);
      parent[x]=a;  // Path compression
        return a;
    }

    // Union operation by rank
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return; // Already in the same set
        }

        // Attach the smaller rank tree under the root of the higher rank tree
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;  
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
}


//import java.util.Arrays;

class DSU {
    private int[] parent;
    private int[] rank;
    private int components;

    // Constructor to initialize DSU with 'n' elements
    public DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        components = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // Find operation with path compression
    public int find(int x) {
        if (x == parent[x]) 
            return x;
        return parent[x] = find(parent[x]);
    }

    // Union operation by rank
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) 
            return;

        // Attach the smaller rank tree under the root of the higher rank tree
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
        components--;
    }

    // Check if there is only one component
    public boolean isSingle() {
        return components == 1;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Sort edges by type in descending order (type 3 first, then 2, then 1)
        Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);

        int addedEdge = 0;

        // Process each edge
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {  // Type 3: common edge for both Alice and Bob
                boolean add = false;

                // If Alice can use the edge
                if (Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                     Bob.union(u, v);
                    add = true;
                }

                // // If Bob can use the edge
                // if (Bob.find(u) != Bob.find(v)) {
                   
                //     add = true;
                // }

                // If either Alice or Bob used the edge, increment addedEdge
                if (add)
                    addedEdge++;

            } else if (type == 2) {  // Type 2: edge for Bob
                if (Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    addedEdge++;
                }
            } else {  // Type 1: edge for Alice
                if (Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    addedEdge++;
                }
            }
        }

        // Check if both Alice and Bob can fully traverse the graph
        if (Alice.isSingle() && Bob.isSingle()) {
            return edges.length - addedEdge;  // Return number of removable edges
        }

        return -1;  // Return -1 if the graph is not fully traversable by both
    }
}
