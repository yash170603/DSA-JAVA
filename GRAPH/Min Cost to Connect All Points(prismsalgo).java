class Solution {
    public int minCostConnectPoints(int[][] points)
     {
         ArrayList<ArrayList<node>> adj = new ArrayList<>();
         for( int i=0;i<points.length;i++)
         {
             adj.add( new ArrayList<>());
         }
         int n = points.length;
        for( int j =0;j<n;j++)
        {
            for( int k= j+1;k<n;k++)
            {
                int x1 = points[j][0];
                int y1 = points[j][1];

                int x2 = points[k][0];
                int y2 = points[k][1];

                int edgew = Math.abs( x1-x2)+ Math.abs( y1-y2);


                adj.get(j).add( new node( edgew, k));
                adj.get( k).add( new node (edgew,j));
            }

        }

        int ans = spanningTree(n, adj);

        return ans;
        
    }
    public int spanningTree(int v,ArrayList<ArrayList<node>> adj  )
	{
	    int sum=0;
	    boolean inmst[]=new boolean[v];
	    
	   
	    PriorityQueue<node> q = new PriorityQueue<>((x,y) -> x.wgh - y.wgh);
	    q.offer( new node ( 0,0));
	    
	    while( !q.isEmpty())
	    {
	        node d = q.poll();
	        int weigh = d.wgh;
	        int chd = d.chl;
	        if( inmst[chd] == true)
	        continue; // pq toh node nikalega hi, par vo pehle kam weight wala edge nikal hi dega, and and agr vo vertex dubara aaega mtlb heavy hoga, so ignore 
	        
	        inmst[chd]=true;
	        sum+=weigh;
	        
	        for( node g : adj.get(chd))
	        {
	            int a = g.wgh;
	            int b= g.chl;
	            
	            if( inmst[b] == false)
	            {
	                q.offer( new node ( a,b));
	            }
	        }
	        
	    }
	    
	    return sum;
	    
	     
	}
}
class node
{
    int wgh;
    int chl;
    node( int wgh, int chl)
    {
        this.wgh=wgh;
        this.chl=chl;
    }
    
}
