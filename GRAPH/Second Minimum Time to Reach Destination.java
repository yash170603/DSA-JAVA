//Approach-1 (Using modified Dijkstra's)
//T.C : O(E logV) - where E = number of edges and V = number of vertices
//S.C : O(V+E)

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
          HashMap<Integer, List<Integer>> map = new HashMap<>();
          for( int i = 0 ; i<= n;i++){
            map.put(i, new ArrayList<>());
          }
          for( int edge[]:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
          }
          PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]-b[0]));

          pq.offer( new int []{0,1});
          int [] dis1= new int [ n+1];
          int [] dis2 = new int [n+1];
          Arrays.fill(dis1,Integer.MAX_VALUE);
          Arrays.fill(dis2,Integer.MAX_VALUE);
          dis1[1]=0;

          while(!pq.isEmpty()){

            int curr[]= pq.poll();
            int dis= curr[0];
            int node= curr[1];

            if(node == n && dis2[n] != Integer.MAX_VALUE)
            return dis2[n];
            if ( (dis/change)%2!= 0){
              int factor = dis/change;
              dis= change*(factor+1);
            }

            for (int x : map.get(node)) {
                if (dis1[x] > dis + time) {
                    dis2[x] = dis1[x];
                    dis1[x] = dis + time;
                    pq.offer(new int[]{dis + time, x});
                } else if (dis2[x] > dis + time && dis1[x] != dis + time) {
                    dis2[x] = dis + time;
                    pq.offer(new int[]{dis + time, x});
                }
            }
        }

          return -1;
    }
}
