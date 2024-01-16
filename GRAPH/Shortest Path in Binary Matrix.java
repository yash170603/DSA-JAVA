class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int row = grid.length;
        int col = grid[0].length;
        int targetx = col-1;
        int targety= row-1;

        if( grid[0][0]  != 0 || grid[targetx][targety] !=0)
        return -1;

       int ans=-1;
        
          int [][] vis = new int [row][col];

          vis[0][0] =1;
          Queue<node> q = new LinkedList<>();
          q.offer( new node(0,0,1));

          while( !q.isEmpty())
          {
              int xx = q.peek().x;
              int yy = q.peek().y;
              int distance = q.peek().count;
              q.remove();
              if( (xx == targetx)  &&  (yy == targety) && ( grid[xx][yy] == 0))
              {
                  ans = distance;
                  break;
              }

              int dr []= { -1, -1, -1, 0, 0, 1, 1, 1 };
              int dc [] ={-1, 0, 1, -1, 1, -1, 0, 1};
              
              for( int i =0;i< 8;i++)
              {
                  int nrow = xx+ dr[i];
                   int ncol = yy+ dc[i];

                   if(  nrow >=0 && ncol>=0 && nrow< row && ncol< col && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0)
                   {
                       vis[nrow][ncol] =1;
                       q.offer( new node( nrow, ncol, distance+1));
                   }
              }
          }


           return ans;
    }
}
class node 
{
    int x;
    int y;
    int count;
    public node( int x, int y, int count)
    {
        this.x =x;
        this.y =y;
        this.count = count;
    }
}
