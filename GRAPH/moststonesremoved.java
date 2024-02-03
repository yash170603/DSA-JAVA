class Solution {
    public int removeStones(int[][] stones)
     {
        int vis[]= new int[stones.length];
        int count =0;
        int n= stones.length;
        for( int i=0;i<n;i++)
        {
            if( vis[i] == 1)
            continue;
            dfs(i,vis,stones);
            count++;
        }
      return n-count;
    }
    public void dfs(int index, int vis[],int [][] stones)
    {
        vis[index]=1;
        int [] temp = new int[2];
        temp=stones[index];
        int pr = temp[0];
        int pc = temp[1];

        for( int k=0;k<stones.length;k++ )
        {
            if( vis[k] !=1)
            {
                 int aa = stones[k][0];
                 int bb = stones[k][1];
                 if( pr == aa || pc == bb)
                 {
                     dfs( k, vis, stones);
                 }
            }
        }
    }
}

// by union find
class Solution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }

        int n = stones.length;

        UnionFind uf = new UnionFind();
        for (int[] edge : stones) {
            uf.union(edge[0] + 10001, edge[1]);
        }

        return n - uf.getCount();
    }

    class UnionFind {
        Map<Integer, Integer> parents;
        int count;

        public UnionFind() {
            parents = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                count++;
            }

            if (x != parents.get(x)) {
                parents.put(x, find(parents.get(x)));
            }

            return parents.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parents.put(rootX, rootY);
            count--;
        }
    }
}
