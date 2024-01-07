import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency list

    public Graph(int V) {
        this.V = V;
        this.adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    // Add edge to the graph
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Topological Sort using DFS
    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (Integer neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        stack.push(v);
    }
}

public class TopologicalSortExample {
    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);

        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> result = graph.topologicalSort();

        System.out.println("Topological Sort:");
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }
}
// adding 2 base case
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private boolean isCyclic(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        if (!visited[node]) {
            visited[node] = true;
            recStack[node] = true;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor] && isCyclic(neighbor, adj, visited, recStack)) {
                    return true;
                } else if (recStack[neighbor]) {
                    return true;
                }
            }
        }

        recStack[node] = false;
        return false;
    }

    private boolean hasCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclic(i, adj, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        stack.push(node);
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }

        return topo;
    }

    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean suffixCondition = false;

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }

                // Check if there is a suffix condition
                if (ptr == len - 1 && s1.length() > s2.length()) {
                    suffixCondition = true;
                }
            }

            // If there is a suffix condition, return null string
            if (suffixCondition) {
                return "";
            }
        }

        // If there is a cycle, return null string
        if (hasCycle(adj, K)) {
            return "";
        }

        List<Integer> topo = topoSort(K, adj);
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char) (it + 'a'));
        }

        return ans.toString();
    }
}

public class TopoSortExample {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        Solution obj = new Solution();
        String ans = obj.findOrder(dict, N, K);

        System.out.println("Topological Sort: " + ans);
    }
}
