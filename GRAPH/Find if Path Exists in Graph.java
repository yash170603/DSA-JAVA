class Solution {
    int parent[];
    int size[];
    public boolean validPath(int n, int[][] edges, int source, int destination) 
    {
        if(source == destination)
        return true;

         parent= new int [n];
         size= new int [n];
        Arrays.fill(size,1);
        for( int i =0;i<n;i++)
        {
            parent[i]=i;
        }

        for( int arr[]:edges)
        {
            int u= arr[0];
            int v = arr[1];

            if( find(u) != find(v))
            {
                union(u,v);
               
            }
        }

        // if( parent[source] == parent[destination] || parent[destination] == source)
        // return true;
        if (find(source) == find(destination)) {
           return true;
          }
        return false;
        
    }


    public int find (int x)
    {
        if( parent[x] ==x)
        {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union( int x, int y)
    {

        int xp = find(x);
        int yp= find(y);

        if( xp == yp)
        {
            return;
        }

        if(xp != yp)
        {
            if( size[xp]>size[yp])
            {
                parent[yp]= x;
                size[xp] += size[yp];
            }
            else if( size[yp]>size[xp])
            {
                parent[xp]= y;
                size[yp] +=size[xp];
            }
            else
            {
                parent[yp]= x;
                size[xp] += size[yp];
            }
        }
    }
}
