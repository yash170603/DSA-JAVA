class Solution {
    public int minimumObstacles(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int [][] dis= new int[n][m];
        for( int arr[]:dis){
            Arrays.fill( arr,1e9);
        }
        Deque<int []> q = new ArrayDeque<>();
        dis[0][0]=0;
        q.offer( new int[]{0,0});
        int [] dx ={0,0,1,-1};
        int [] dy = {1,-1,0,0};
        while(! q.isEmpty()){
              int currCell [] = q.pollFirst();
              int x = currCell[0];
              int y = currCell[1];
               for( int i=0;i<4;i++){
                   int nx= x+dx[i];
                   int ny= y+dy[i];
                    if( nx>=0 && nx<n && ny>=0 && ny<m){
                        if( dis[x][y]+grid[nx][ny]<dis[nx][ny]) {
                                dis[nx][ny] = dis[x][y]+grid[nx][ny];
                                if( grid[nx][ny] ==0)
                                    q.offerFirst(new int []{nx,ny});
                                else
                                q.offerLast(new int []{nx,ny});
                        } 
                    }
               }
        }

          return dis[n-1][m-1];

    }
}
