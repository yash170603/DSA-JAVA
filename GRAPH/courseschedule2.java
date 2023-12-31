class Solution {
  // impossible to take all courses if there is any cycle as [1,0][0,1] we cant chose 0 without 1 and 1 without zero

    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] adjList = new List[n];;
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
            if(!dfs(adjList, i, visiting, visited, res)) {
                return new int[0];
            }
        }
        int[] resArray = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            resArray[i] = res.get(i);   
        }
        return resArray;
    }
    
    public boolean dfs(List<Integer>[] adjList, int curr, boolean[] visiting, boolean[] visited, List<Integer> res) {
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
            if(!dfs(adjList, neighbour, visiting, visited, res)) {
                return false;
            }
        }
        visiting[curr] = false;
        visited[curr] = true;
        res.add(curr);
        return true;
    }
    
}
