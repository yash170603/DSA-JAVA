class Solution {
    public int minDays(int[][] grid) {

        int init= noOfIslands(grid);
        if(init>1 || init ==0)
            return 0;

        int n= grid.length;
        int m= grid[0].length;
        for( int i =0 ; i< n; i++){
            for( int j = 0; j<m;j++){
                if( grid[i][j]==1){
                    grid[i][j]=0;  // changing the island
                    int ans = noOfIslands(grid);
                    if( ans>1 || ans==0)
                    {
                        return 1;
                    }
                    else{
                        grid[i][j]=1;
                    }
                }
            }
        }


        return 2;
    }

    public int noOfIslands( int [][] grid){
        int n= grid.length;
        int m= grid[0].length;
        int vis[][]= new int [n][m];
        int noI= 0;


        for( int i =0; i< n;i++){
            for( int j =0 ; j< m;j++){
                if( grid[i][j]==1 && vis[i][j]!=1){
                    dfs(grid,vis,i,j);
                    noI++;
                }
            }
        }

        return noI;
    }
    public void dfs(int [][]grid, int [][] vis, int i, int j){
        int row = grid.length;
        int col= grid[0].length;

        if( i< 0 || i==row || j<0 || j==col|| vis[i][j]==1||grid[i][j]!=1){
            return;
        }
        vis[i][j]=1;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};

        for( int arr[]:dir){
            int nrow= i+arr[0];
            int ncol= j+arr[1];
            dfs(grid,vis,nrow,ncol);
        }
    }
}
