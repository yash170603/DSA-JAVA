class Solution{
     
	static int spanningTree(int V, int E, int edges[][]){
	     Arrays.sort( edges, (a,b)->Integer.compare(a[2],b[2]));
	    
	   int [] rank = new int[V];
	   int [] parent= new int[V];
	     for( int i=0;i<V;i++)
	     {
	        rank[i]=1;
	        parent[i]=i;
	     }
	     int sum = 0;
        int edgeCount = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            int parentU = find(u,parent);
            int parentV = find(v,parent);

            if (parentU != parentV) {
                union(parentU, parentV,rank,parent);
                sum += wt;
                edgeCount++;
                if (edgeCount == V - 1)
                    break;
            }
        }
        return sum;
   
	}
	
	public static  int find( int x,int[] parent)
	{
	    if(parent[x]==x)
	    return x;
	    
	    int a = find(parent[x],parent);
	    parent[x]=a;
	    return a;
	}
	
	public static void union( int x, int y, int [] rank, int [] parent)
	{
	    int xp = find(x,parent);
	    int yp = find(y,parent);
	    if( xp == yp) return;
	    
	    if( rank[xp]>rank[yp])
	    {
	        parent[yp]=xp;
	        rank[xp]++;
	    }
	    else if( rank[yp]>rank[xp])
	    {
	        parent[xp]=yp;
	        rank[yp]++;
	    }
	    else
	    {
	         parent[yp]=xp;
	        rank[xp]++;
	    }
	}
}
