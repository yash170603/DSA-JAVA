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
