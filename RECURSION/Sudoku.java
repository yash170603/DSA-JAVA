class Solution {
   public void solveSudoku(char[][] board)
 {
        
        solve(board);
}
  

    public boolean solve(char[][] board)
    {
        for (int rows = 0; rows < board.length; rows++) {
            for (int col = 0; col < board.length; col++) {
                if (board[rows][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, rows, col, ch)) {
                            board[rows][col] = ch;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[rows][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int rows, int col , char ch)
    {
         for (int i = 0; i < 9; i++) {
      if (board[i][col] == ch)
        return false;

      if (board[rows][i] == ch)
        return false;

      if (board[3 * (rows / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
        return false;
    }
    return true;
    }
}
