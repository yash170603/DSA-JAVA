class Solution {
    public boolean exist(char[][] board, String word)
     {
         int rows = board.length;
        int cols = board[0].length;
        int index =0;
       int vis  [][] = new int [rows][cols];

        for(int x=0;x<rows;x++)
        {
            for(int y=0;y<cols;y++)
            {
                vis[x][y] =0;
            }
        }


        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j] == word.charAt(index) )
                {
                    if(checks(i,j,rows,cols,index,board,vis,word))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }


     public boolean checks(int i, int j, int rows, int cols, int index, char [][] board, int [][] vis,String word)
     {

        if (index == word.length() - 1) {
            return true;
        }

        // Mark the current cell as visited
       

        // Right
        if (j + 1 < cols && board[i][j + 1] == word.charAt(index + 1) && vis[i][j + 1] == 0) {
             vis[i][j] = 1;
            if (checks(i, j + 1, rows, cols, index + 1, board, vis, word)) {
                return true;
            }
            vis[i][j] = 0;
        }

        // Left
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(index + 1) && vis[i][j - 1] == 0) {
             vis[i][j] = 1;
            if (checks(i, j - 1, rows, cols, index + 1, board, vis, word)) {
                return true;
            }
            vis[i][j] = 0;
        }

        // Down
        if (i + 1 < rows && board[i + 1][j] == word.charAt(index + 1) && vis[i + 1][j] == 0) {
             vis[i][j] = 1;
            if (checks(i + 1, j, rows, cols, index + 1, board, vis, word)) {
                return true;
            }
            vis[i][j] = 0;
        }

        // Up
        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(index + 1) && vis[i - 1][j] == 0) {
             vis[i][j] = 1;
            if (checks(i - 1, j, rows, cols, index + 1, board, vis, word)) {
                return true;
            }
            vis[i][j] = 0;
        }

        // Unmark the current cell as visited (backtrack)
        

        return false;

     }

}
