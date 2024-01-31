import java.util.Arrays;

class DSU {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize DSU with 'n' elements
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        // Initially, each element is its own parent, and rank is 0.
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find operation with path compression
    public int find(int x) {
        if (parent[x] == x) {
            return ;
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

public class Main {
    public static void main(String[] args) {
        int n = 5; // Number of elements
        DSU dsu = new DSU(n);

        // Example of using find and union operations
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(1, 4);

        System.out.println("Are 0 and 4 in the same set? " + (dsu.find(0) == dsu.find(4)));
        System.out.println("Are 1 and 3 in the same set? " + (dsu.find(1) == dsu.find(3)));
    }
}
