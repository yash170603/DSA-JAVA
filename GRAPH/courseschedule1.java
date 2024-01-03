class Solution {
    public boolean canFinish(int n, int[][] prerequisites)
     {
         List<Integer>[] adjList = new List[n];
         boolean f = true;
        for(int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] prerequisite : prerequisites) {
            adjList[prerequisite[0]].add(prerequisite[1]);
        }
        List<Integer> res = new ArrayList<>();
        boolean[] visiting = new boolean[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!dfs(adjList, i, visiting, visited)) {
                f = false;
            }
        }
        return f;
    }

       public boolean dfs(List<Integer>[] adjList, int curr, boolean[] visiting, boolean[] visited) {
        // node has already been visited and added to res
        if(visited[curr]) {
            return true;
        }
        // we are encoutering a node already on the path, aka there is a cycle
        if(visiting[curr]) {
            return false;
        }
        visiting[curr] = true;
        for(int neighbour : adjList[curr]) {
            if(!dfs(adjList, neighbour, visiting, visited)) {
                return false;
            }
        }
        visiting[curr] = false;
        visited[curr] = true;
        //res.add(curr);
        return true;
    }
}
s
