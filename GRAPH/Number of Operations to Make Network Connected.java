class Solution {
    int [] rank;
    int [] parent ;
    public int makeConnected(int n, int[][] e)
     {
        rank = new int [n];
        parent = new int [n];
        for( int i=0;i<n;i++)
        {
            rank[i]=1;
            parent[i]=i;
        }
        int edges =0;
        int conn=1;

        for( int  f [] : e)
        {
            int a = f[0];
            int b = f[1];

            if( find(a) != find(b))
            {
                edges++;
                conn++;
                union( a,b);
            }
            else
            {
                edges++;
            }
        }
     
     if( edges < n-1)
     return -1;

     return n-conn;

    }

    public int find( int x)
    {
        if( parent[x]==x)
        return x;

        int a = find(parent[x]);
        parent[x]=a;
        return a;
    }

    public void union( int x, int y)
    {
        int xp = find(x);
        int yp= find(y);

        if( xp == yp)
        return;

        if( rank[xp]>rank[yp])
        {
            parent [yp] = xp;
            rank[xp]++;
        }
       else if( rank[yp]>rank[xp])
        {
            parent [xp] = yp;
            rank[yp]++;
        }
        else
        {
            parent [yp] = xp;
            rank[xp]++;
        }

    }
}
