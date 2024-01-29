class Solution {
    public int findTheCity(int n, int[][] edges, int t)
     {
        int [][]mat = new int [n][n];
        for( int [] row: mat )
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
            for(int i =0;i<edges.length;i++)
        {
                int e1 = edges[i][0];
                int e2 = edges[i][1];
                int weight = edges[i][2];

                mat[e1][e2]=weight;
                mat[e2][e1]=weight;
           
        }
          for (int i = 0; i < n; i++) mat[i][i] = 0;

        for( int via =0;via<n;via++)
        {   
            for( int a =0;a<n;a++)
            {
                for(int b =0;b< n;b++)
                {
                    if( mat[a][via] == Integer.MAX_VALUE||
                     mat[via][b] ==Integer.MAX_VALUE)
                    continue;

                    if( mat[a][b] > mat[a][via] + mat[via][b])
                    {
                        mat[a][b] = mat[a][via] + mat[via][b];
                    }
                   // mat[a][b] = Math.min( mat[a][b],mat[a][via] + mat[via][b] );
                }
            }
        }

        int count =Integer.MAX_VALUE;
        int city=0;
        for( int k =0;k<n;k++)
        {  
            int lc=0;
            for( int l=0;l<n;l++)
            {
                if( mat[k][l] <= t)
                {
                    lc++;
                }
            }

            if( lc<=count)
            {
                count=lc;
                city =k;
            }
        }

        return city;
     }  
        
}


//this isdiksjtras wasy, fo it for all vertices
// import java.util.ArrayList;
// import java.util.List;
// import java.util.PriorityQueue;

// class Pair {
//     int first;
//     int second;

//     public Pair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

// class Solution {
//     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//         List<Pair>[] adj = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             adj[i] = new ArrayList<>();
//         }

//         for (int[] it : edges) {
//             adj[it[0]].add(new Pair(it[1], it[2]));
//             adj[it[1]].add(new Pair(it[0], it[2]));
//         }

//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
//         int minCont = Integer.MAX_VALUE;
//         int city = 0;

//         for (int i = 0; i < n; i++) {
//             int[] dist = new int[n];
//             for (int j = 0; j < n; j++) {
//                 dist[j] = Integer.MAX_VALUE;
//             }

//             dist[i] = 0;
//             pq.add(new Pair(0, i));

//             while (!pq.isEmpty()) {
//                 Pair top = pq.poll();
//                 int distance = top.first;
//                 int node = top.second;

//                 for (Pair neighbor : adj[node]) {
//                     int adjDist = neighbor.second;
//                     int adjNode = neighbor.first;

//                     if (adjDist + distance < dist[adjNode]) {
//                         dist[adjNode] = distance + adjDist;
//                         pq.add(new Pair(dist[adjNode], adjNode));
//                     }
//                 }
//             }

//             int cnt = 0;
//             for (int j = 0; j < n; j++) {
//                 if (dist[j] <= distanceThreshold) {
//                     cnt++;
//                 }
//             }

//             if (cnt <= minCont) {
//                 minCont = cnt;
//                 city = i;
//             }
//         }

//         return city;
//     }
// }
