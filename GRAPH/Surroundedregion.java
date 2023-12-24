class Solution {
    public void solve(char[][] board) 
    {
         int row= board.length;
        int col = board[0].length;
        int [][] vis = new int [row][col];
        //first row
        for( int i =0; i<col;i++)
        {
            if( board[0][i] == 'O'  &&  vis[0][i] == 0)
            {
                dfs(0,i,vis,board,row,col);
            }
        }
        //last row
        for( int j = 0;j<col;j++)
        {
            if( board[row-1][j] == 'O'  &&  vis[row-1][j] == 0)
            {
                dfs( row-1,j,vis,board,row,col);
            }
        }
        //forst col
        for( int jj=0;jj<row;jj++)
        {
            if( board[jj][0] == 'O' && vis[jj][0] == 0)
            {
                dfs(jj,0,vis,board,row,col);
            }
        }
        //last col  
   for( int kk=0;kk<row;kk++)
        {
            if( board[kk][col-1] == 'O'  && vis[kk][col-1] == 0)
            {
                dfs(kk,col-1,vis,board,row,col);
            }
        }
       for( int y =0;y<row;y++)
       {
           for( int v =0;v<col;v++)
           {
               if(vis[y][v] == 0 && board[y][v] == 'O')
               {
                   board[y][v] = 'X';
               }
              
           }
       }    

    }

      public void dfs( int a, int b,int [][]vis, char [][] board, int row, int col)
    {
       if( a<0 || b<0 || a== row||b==col|| vis[a][b] == 1 || board[a][b] != 'O')
       return;
        vis[a][b] =1;
        
        int [] dr = {0,0,1,-1};
        int [] dc = {1,-1,0,0};
        for( int q =0;q<dr.length;q++)
        {
            int nrow = a+dr[q];
            int ncol = b+ dc[q];
            // if( ncol>=0 && ncol < col && nrow>=0 && nrow< row && board[nrow][ncol] == 'O'
            //  && vis[nrow][ncol] == 0)
            dfs( nrow, ncol, vis, board, row, col);
        }
    }

}
