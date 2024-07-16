import java.util.*;

class DSU {
    private int[] size;
    private int[] par;

    public DSU(int n) {
        size = new int[n];
        par = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (size[x] > size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        size[y] += size[x];
        par[x] = y;
    }
}

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Map<Integer, List<Integer>> valToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valToNodes.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        DSU dsu = new DSU(n);
        int result = n;
        boolean[] isActive = new boolean[n];

        for (Map.Entry<Integer, List<Integer>> entry : valToNodes.entrySet()) {
            List<Integer> indexes = entry.getValue();
            for (int node : indexes) {
                for (int neighbor : graph.get(node)) {
                    if (isActive[neighbor]) {
                        dsu.merge(node, neighbor);
                    }
                }
                isActive[node] = true;
            }

            Map<Integer, Integer> leaderCount = new HashMap<>();
            for (int node : indexes) {
                int leader = dsu.find(node);
                leaderCount.put(leader, leaderCount.getOrDefault(leader, 0) + 1);
            }

            for (int count : leaderCount.values()) {
                result += (count * (count - 1)) / 2;
            }
        }

        return result;
    }

   
}
