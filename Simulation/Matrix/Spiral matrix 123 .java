sp-1

  class Solution {
    public List<Integer> spiralOrder(int[][] matrix)
     {
        // left->down->right->up
        int left=1;
        int down=2;
        int right = 3;
        int up =4;
        List<Integer> ans = new ArrayList<>();
        int n= matrix.length;
        int m = matrix[0].length;
        int move = left;
        int vis [][]= new int[n][m];
        int i =-1;int j =-1;
        int viscount=0;
        while(viscount != m*n)
        {
            if( move == left )
            {
                i++;
                j++;
                while(j<=m-1 )
                {
                    if( vis[i][j] == 1)
                    {
                        move = down;
                        break;
                    }
                    ans.add(matrix[i][j]);
                    vis[i][j]=1;
                    viscount++;
                    j++;
                    if( j == m)
                    {
                        move = down;
                    }
                }
            }
            if( move  == down)
            {
                i ++;
                j--;
                while( i<= n-1 )
                {
                    if( vis[i][j] ==1)
                    {
                        move = right;
                        break;
                    }
                    ans.add(matrix[i][j]);
                    vis[i][j]=1;
                    viscount++;
                    i++;
                    if( i == n)
                    {
                          move = right;
                    }
                }
            }
            if( move == right)
            {
                i--;
                j--;
                while( j>=0 )
                {
                    if( vis[i][j] == 1)
                    {
                        move= up;
                        break;
                    }
                    ans.add(matrix[i][j]);
                    vis[i][j]=1;
                    viscount++;
                    j--;
                    if( j == -1)
                    {
                        move = up;
                    }
                }
            }
            if( move == up)
            {
                i--;
                j++;              
                while( i>=0)
                {
                    if( vis[i][j] == 1)
                    {
                        move  = left;
                        break;
                    }
                    ans.add(matrix[i][j]);
                    vis[i][j] =1;
                    viscount++;
                    i--;
                }
            }
        }     
         return ans;
    }
}



sp-2

  class Solution {
    public int[][] generateMatrix(int n) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[n][n];
        int dir = 0, i = 0, j = 0, init = 1;

        while (init <= n * n) {
            ans[i][j] = init++;
            
            // Calculate the next position
            int nextI = i + directions[dir][0];
            int nextJ = j + directions[dir][1];
            
            // Check if the next position is out of bounds or already filled
            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || ans[nextI][nextJ] != 0) {
                dir = (dir + 1) % 4; // Change direction
                nextI = i + directions[dir][0];
                nextJ = j + directions[dir][1];
            }
            
            // Move to the next position
            i = nextI;
            j = nextJ;
        }

        return ans;
    }
}




sp-3


  class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {
            {0, 1},  // EAST
            {1, 0},  // SOUTH
            {0, -1}, // WEST
            {-1, 0}  // NORTH
        };
        
        int[][] result = new int[rows * cols][2];  
        int step = 0; // how many steps to move
        int dir  = 0; // which direction

        result[0] = new int[]{rStart, cStart};
        int count = 1;

        while (count < rows * cols) {
            // When we move EAST or WEST, we need to increase our steps by 1
            if (dir == 0 || dir == 2) step++;

            for (int i = 0; i < step; i++) {
                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) { // check valid
                    result[count++] = new int[]{rStart, cStart};
                }
            }

            dir = (dir + 1) % 4; // turn to next direction
        }
        
        return result;
    }
}
