class Solution {
    int row;
    int col;
    public int numIslands(char[][] grid)
     {
          row = grid.length;
          col = grid[0].length;
       boolean vis [][]= new boolean [row][col];
         int count=0;
         for( int i =0;i<row;i++)
         {
             for( int j =0;j< col;j++)
             {
                 if( grid[i][j] =='1' && vis[i][j] == false )
                 {
                     count++;
                     dfs(i,j,vis,grid);
                 }
             }
         }

         return count;
        
    }

    public void dfs( int x, int y, boolean vis[][], char grid [][])
    {
        vis[x][y]= true;

        int r[]={-1,0,1,0};
        int c[]={0,1,0,-1};

        for(int a =0;a< r.length;a++)
        {
            int nrow=x+r[a];
            int ncol = y+c[a];

            if( nrow>=0 && nrow<row && ncol>=0 && ncol<col && grid[nrow][ncol] == '1' && vis[nrow][ncol] == false)
            {
                dfs( nrow, ncol,vis,grid);
            }
        }
    }
}
