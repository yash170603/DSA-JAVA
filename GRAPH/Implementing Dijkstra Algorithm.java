class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)-> x.distance - y.distance);
        int dist[] = new int [V];
        for( int i=0;i< V;i++)
        {
            dist[i]=(int)1e9;
        }
        dist[S]=0;
        pq.offer( new pair( 0,S));
        
        while( ! pq.isEmpty())
        {
            int distancecovered = pq.peek().distance;
            int vertex = pq.peek().node;
            pq.poll();
            
            for( int a =0;a< adj.get(vertex).size();a++)
            {
                int dis = adj.get(vertex).get(a).get(1);
                int neigh = adj.get(vertex).get(a).get(0);
                
                if( distancecovered+ dis < dist[neigh])
                {
                    dist[neigh] =  distancecovered+ dis; 
                    pq.offer ( new pair (dist[neigh], neigh) );
                }
            }
        }
        return dist;
       
    }
}
class pair
{
    int distance;
    int node ;
    
    public pair(int distance, int node)
    {
        this.distance = distance;
        this.node = node;
    }
}

