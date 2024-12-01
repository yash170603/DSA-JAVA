//  so the thing is --> its a tree, so we need to remove the edges as a child.. else removing the parent edges causes increase in TC.
//  algorithm is like simple dfs, which finds the wieght of all edges. and applies dp on them.

//  for each node , ATQ, We should ask-> which nodes to remove? and how many to remove

//  if a parent edges for the node is remove,, consider it a diff component whose weight is also valid, see eg-1.

//  therefore for each node we can calculate weight in two ways, if the parent was removed? or oif not

//  if it was removed,  the no of nodes to be removed from childrens will be less, other wise more, as  
//  example-->
//  if for a node(T) max neighbours can be 2, and if parent is attached, and the node has 3 child nodes(tree),, the maximum number of  nodes thaht  can be removed from childrens is 2,,,  have the parent edge was removed we only need to remove 1 edge to have 2 neighbouring nodes ,, for node T.

// for this the formulas is --> int edgesToRemove = Math.max(0, gr.get(node).size() - k - isParEdgeRemoved);

// base case is a single node,,, consider it as the last node before null, whoch contributes nothing to the weight,,
// for the base case, the no of edges to be removed will be 0 , and candidated which as vaible for remoiving and not removing, will be zero, 
// there fore the dp state for this node will be 0;( i think this is for both caes, wheter parent edge was removed or not)


//  now suppose x has two nodes as neighbour..  
//                x
//              /   \
//            n1    n2

// two combinations,, keep n1 and remove n2, or remove n1 and keep n2
// i.e if resultant weight is better after removing n1..  -->  keep n2 + remove n1 > keep n1 + remove n2==  keep n2- remove n2 > keep n1-remove n1

// this shows that if removing n1 is better, the resultant of this euqation for n1 will be less, 
// i.e for better results, we need the candidates whose  values keep nx- remove nx is least..

// sort the candidates according to this.

// candidates.sort((p1, p2) -> Long.compare(p1[0] - p1[1], p2[0] - p2[1]));


// now choose first candidates to be removed from this... and the rest of candidates have the choice to be removed or not.

// return the result,stored in dp.



class Solution {
    static class Edge {
        int neighbour;
        int weight;

        Edge(int neighbour, int weight) {
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    private long[][] dp;
    private List<List<Edge>> gr;
    private int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        this.k = k;
        gr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            gr.get(edge[0]).add(new Edge(edge[1], edge[2]));
            gr.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }
        dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1L);
        }
        return solve(0, 0, -1);
    }

    private long solve(int node, int isParEdgeRemoved, int parent) {
        if (dp[node][isParEdgeRemoved] != -1) return dp[node][isParEdgeRemoved];

        int edgesToRemove = Math.max(0, gr.get(node).size() - k - isParEdgeRemoved);
        long answer = 0;
        List<long[]> candidates = new ArrayList<>();
        for (Edge edge : gr.get(node)) {
            int ne = edge.neighbour, wt = edge.weight;
            if (ne != parent) {
                long dontRemove = solve(ne, 0, node) + wt;
                long remove = solve(ne, 1, node);
                candidates.add(new long[]{dontRemove, remove});
            }
        }

        candidates.sort((p1, p2) -> Long.compare(p1[0] - p1[1], p2[0] - p2[1]));
        for (int i = 0; i < candidates.size(); i++) {
            long dontRemove = candidates.get(i)[0];
            long remove = candidates.get(i)[1];
            if (i < edgesToRemove) {
                answer += remove;
            } else {
                answer += Math.max(dontRemove, remove);
            }
        }
        return dp[node][isParEdgeRemoved] = answer;
    }
}
