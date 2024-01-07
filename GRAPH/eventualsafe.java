import java.util.List;  // passed 92 out of 112
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    List<Integer> ans;
    List<Integer> term;
    boolean[] visiting;
    List<List<Integer>> adj;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ans = new ArrayList<Integer>();
        term = new ArrayList<Integer>();
        adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                term.add(i);
            }
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                temp.add(graph[i][j]);
            }
            adj.add(temp);
        }


        visiting = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visiting[i]) {
                boolean b = dfs(i, graph);
                if (b)
                    ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public boolean dfs(int node, int[][] graph) {
        if (term.contains(node))
            return true;

        visiting[node] = true;

        List<Integer> n = adj.get(node);

        for (int neighbour : n) {
            if (visiting[neighbour])
                return false;

            if (!dfs(neighbour, graph))
                return false;
        }

        visiting[node] = false;
        return true;
    }
}

// answer
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean [] visited = new boolean[n];

        int [] unsafe = new int[n];
        for(int i = 0;i<n;i++){
            if(unsafe[i]==0){
                visited[i] = true;
                dfs(i,visited,graph,unsafe);
                visited[i] = false;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<unsafe.length;i++){
            if(unsafe[i]==1) result.add(i);
        }
        return result;
    }

    public boolean dfs(int node, boolean [] visited, int [][] graph, int[] unsafe){
        boolean isSafe = true;
        for(int neighbor: graph[node]){

            if(visited[neighbor] || unsafe[neighbor]==2){
                isSafe = false;
                break;
            }
            if(unsafe[neighbor]==1) continue;
            visited[neighbor] = true;
            if(!dfs(neighbor, visited, graph, unsafe)) isSafe = false;
            visited[neighbor] = false;
        }
        unsafe[node] = isSafe?1:2;
        return isSafe;
    }
}
