class Solution {
    int n,m;
    public int maxMoves(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int  [][] dp = new int[n+1][m+1];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans =0;
        for( int row=0;row<n;row++){
            int temp= solve( row,0,dp,grid);
            ans=Math.max(ans,temp);
        }
        return ans;
    }
     public int solve( int i, int j, int [][] dp, int [][] grid){

        if(dp[i][j] !=-1) return dp[i][j];

        int up=0,right=0,down=0;

        if(  i-1>=0 && j+1<m && grid[i-1][j+1]> grid[i][j]){
             up=1+ solve( i-1,j+1,dp,grid);
        }
        if( j+1<m && grid[i][j+1]>grid[i][j]){
            right = 1+ solve( i,j+1,dp,grid);
        }
        if( i+1<n && j+1<m && grid[i+1][j+1]> grid[i][j]){
            down=1+solve(i+1,j+1,dp,grid);
        }
        return dp[i][j]= Math.max(up,Math.max(right,down));
     }


}
