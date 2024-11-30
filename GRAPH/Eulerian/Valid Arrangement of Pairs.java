// import java.util.*;

// class Solution {
//     public int[][] validArrangement(int[][] pairs) {
//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         HashMap<Integer, Integer> degree = new HashMap<>();
//         // HashMap<Integer, Integer> outdegree = new HashMap<>();
//         for (int[] edge : pairs) {
//             int u = edge[0];
//             int v = edge[1];
//             // outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
//             degree.put(v, degree.getOrDefault(v, 0) + 1);
//             map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
//             map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
//         }
//         int source = Integer.MAX_VALUE;
//         for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
//             int node = entry.getKey();
//             int deg = entry.getValue();
//             if (deg % 2 != 0) {
//                 source = node;
//                 break;
//             }
//         }
//         List<int[]> newEdges = solve(map, source);
//         int ans[][] = new int[newEdges.size()][2];

//         int index = 0;
//         for (int[] edge : newEdges) {
//             ans[index] = edge;
//             index++;
//         }
//         return ans;
//     }

//     public List<int[]> solve(HashMap<Integer, List<Integer>> map, int src) {
//         List<int[]> ans = new ArrayList<>();
//         Stack<Integer> s = new Stack<>();
//         s.push(src);

//         while (!s.isEmpty()) {
//             int thisNode = s.peek();
//             if (hasNext(map, thisNode)) {
//                 int nextNode = nextVertex(map, thisNode);
//                 ans.add(new int[] { thisNode, nextNode });
//                 deleteEdge(map, thisNode, nextNode);
//                 s.push(nextNode);
//             } else
//                 s.pop();
//         }
      
//         return ans;
//     }
//     public void deleteEdge(HashMap<Integer, List<Integer>> map, int u, int v) {
//     map.get(u).remove((Integer) v);
//     map.get(v).remove((Integer) u);


       
//     }
//     public int nextVertex(HashMap<Integer, List<Integer>> map, int currNode) {
//         List<Integer> list = map.get(currNode);
//         return list.get(0);
//     }

//     public boolean hasNext(HashMap<Integer, List<Integer>> map, int currNode) {
//         return map.getOrDefault(currNode, new ArrayList<>()).size() > 0;
//     }
// }
import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>();

        for (int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];
            degree.put(u, degree.getOrDefault(u, 0) + 1); // Outdegree increment
            degree.put(v, degree.getOrDefault(v, 0) - 1); // Indegree increment
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
             //map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int source = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            int balance = entry.getValue();
            if (balance == 1) {
                source = entry.getKey();
                break;
            }
        }

        List<int[]> newEdges = solve(map, source);
        int[][] ans = new int[newEdges.size()][2];
        for (int i = 0; i < newEdges.size(); i++) {
            ans[i] = newEdges.get(i);
        }
        return ans;
    }

    public List<int[]> solve(HashMap<Integer, List<Integer>> map, int src) {
        List<int[]> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
       List<Integer> path = new ArrayList<>();
        s.push(src);

        while (!s.isEmpty()) {
            int thisNode = s.peek();
            if (hasNext(map, thisNode)) {
                int nextNode = nextVertex(map, thisNode);
                //ans.add(new int[]{thisNode,nextNode});
                deleteEdge(map, thisNode, nextNode);
                s.push(nextNode);
            } else {
                path.add(s.pop());
               //s.pop();
                
            }
        }
             
        for ( int i = path.size() - 1; i > 0; i--) {
            
            ans.add(new int[] { path.get(i), path.get(i - 1) });
        } 
        return ans;
    }

    public void deleteEdge(HashMap<Integer, List<Integer>> map, int u, int v) {
        map.get(u).remove((Integer) v);
        //map.get(v).remove((Integer) u);
    }

    public int nextVertex(HashMap<Integer, List<Integer>> map, int currNode) {
        return map.get(currNode).get(0);
    }

    public boolean hasNext(HashMap<Integer, List<Integer>> map, int currNode) {
        return  !map.getOrDefault(currNode, new ArrayList<>()).isEmpty();
    }
}
