class Solution {
    public int maximumInvitations(int[] fav) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = fav.length;
        for (int i = 0; i < n; i++) {
            int req = fav[i];
            map.computeIfAbsent(req, k -> new ArrayList<>()).add(i);  // rev graph for easy bfs traversal . 
        }
        boolean[] vis = new boolean[n];
        int maxCycle = 0;
        int maxCouple = 0;

        for (int i = 0; i < n; i++) {



            if (vis[i] == false) {   // hrere the component changes.  the  method to graph   traversal we use will mark all the nodes of a single component as true
                int curr = i;
                int currDis = 0;
                HashMap<Integer, Integer> cycle = new HashMap<>(); // not inside the while loop
                // when will a cycle appear?  == see if the cycle exist, the nextNode is being made  currNode line 41,eg-> for 1 nextNode is 0, at line 41 nextNode = 0=currNode,-> therefore   0-> 1-> 0 so while vis[0]!= true, cycle isnt found
                while (vis[curr] != true) {
                    vis[curr] = true;
                    cycle.put(curr, currDis);
                    int nextNode = fav[curr];
                    currDis++;

                    if (cycle.containsKey(nextNode)) {   /// cycle exists here  set<0,1> for 1 nextNode =0, 0 exists in set, so cycle exists

                        int thisCycle = currDis - cycle.get(nextNode);
                        maxCycle = Math.max(maxCycle, thisCycle);

                        if (thisCycle == 2) {
                            boolean[] visitedNodes = new boolean[n];
                             visitedNodes[curr] = true;
                             visitedNodes[nextNode] = true;   // consider - 2->4->0->6->3<->5 
                             //ab youll start from 0, and keep marking 0,6,3,5 as true in vis[]. now 3 and 5 are 2 lenght cycle so youll bfs , but if you use the og vis in bfs, 0 and 6 are true, so wont be traversed. ans will eb only 2 instead of 6, wrong, use a new vis for bfs   
                            maxCouple += 2 + BFS(curr, map, visitedNodes) + BFS(nextNode, map, visitedNodes);  // this will add answers of all components present, not only a single one, for eg if 2 compoennsts were -> 0<->1 and 3<->2
                        }
                        break;  // why break?  ---. one component will only have a single cycle, so better break it off this is according to question structure

                    }

                    curr =nextNode;   // checkeing for thr nextNode  
                } // while loop ends here 
            }


        }


        return Math.max(maxCycle,maxCouple);  // answer is either the one big cycle of a component, or the sum of 2 length cyclic paths of other small ones
    }
     public int BFS(int start, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>(); // {node, path length}
        queue.add(new int[]{start, 0});
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currNode = current[0];
            int dist = current[1];

            for (int neighbor : adj.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                    maxDistance = Math.max(maxDistance, dist + 1);
                }
            }
        }

        return maxDistance;
    }
