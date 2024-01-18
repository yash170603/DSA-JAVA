class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
     {
         ArrayList<ArrayList<pair>> adj = new ArrayList<>();
         for( int i =0;i<n;i++)
         {
             adj.add( new ArrayList<>());
         }
         for( int a=0;a<flights.length;a++)
         {
             adj.get(flights[a][0]).add( new pair (flights[a][1], flights[a][2])) ;
         }

         Queue<triple> q = new LinkedList<>();
         q.offer( new triple( 0,src,0));

         int dist[]= new int [n];
         for( int p=0;p<n;p++)dist[p]=(int)1e9;
         dist[src]=0;
         while(!q.isEmpty())
         {
             int stops = q.peek().stop;
             int vertex= q.peek().vertexreached;
             int money = q.peek().amount;
             q.poll();

             if( stops>K)
             continue;

             for( pair d: adj.get(vertex))
             {
                 int  value = d.node;
                 int mm= d.price;

                 if( mm+money< dist[value] && stops<=K)
                 {
                     dist[value]= mm+money;
                     q.offer( new triple ( stops+1, value, mm+money));
                 }
             }
         }

  if( dist[dst] == (int)1e9)
  return -1;

  return dist[dst];

        
    }
}
class pair // adjlis
{
    int node;
    int price;
    pair( int node, int price)
    {
        this.node = node;
        this.price = price;
    }
}
class triple // queue
{ 
    int stop;
    int vertexreached;
    int amount;
    triple( int stop, int vertexreached,int amount)
    {
        this.stop = stop;
        this.vertexreached = vertexreached;
        this.amount = amount;
    }

}
