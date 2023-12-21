//BFS
class node
{
    int x;
    int y;
    node(int x, int y)
    {
        this.x=x;
        this.y = y;
    }
}
class Solution {
    public node create(int x, int y)
    {
        node n = new node(x,y);
        return n;
    }
     public boolean safe(int row,int col,int image[][]){
        if(row>=image.length|| col>=image[0].length || col<0 || row<0){
            return false;
        }
        return true;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
     {
        if(image[sr][sc] == color)
        return image;
         int rows = image[0].length;
         int cols = image.length;
          int initial =image[sr][sc];
         image[sr][sc] = color;
       
         Queue<node> q = new LinkedList<>();
         node damage = create(sr,sc);
         q.offer(damage);
         while( !q.isEmpty())
         {
             for( int u =0;u<q.size();u++)
             {
                 node temp = q.poll();
                 int a = temp.x;
                 int b = temp.y;                
                 int drow[] = {0,0,1,-1};
                 int dcol[] = {1,-1,0,0};
                 for( int t =0;t<drow.length;t++)
                 {
                     int nrow = a+drow[t];
                     int ncol = b+dcol[t];
                     if( safe(nrow,ncol,image) ==  true && image[nrow][ncol] == initial )
                     {
                         image[nrow][ncol] = color;
                         node tempo =  create(nrow,ncol);
                         q.offer(tempo);
                     }
                 }
             }
         }
         return image;
    }
}



//DFS
class Solution
{
    private void dfs(int row, int col, 
     int[][] ans,
     int[][] image, 
     int newColor, int delRow[], int delCol[],
     int iniColor) {
        // color with new color
        ans[row][col] = newColor; 
        int n = image.length;
        int m = image[0].length; 
        // there are exactly 4 neighbours
        for(int i = 0;i<4;i++) {
            int nrow = row + delRow[i]; 
            int ncol = col + delCol[i]; 
            // check for valid coordinate 
            // then check for same initial color and unvisited pixel
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && 
            image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor); 
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // get initial color
        int iniColor = image[sr][sc]; 
        int[][] ans = image; 
        // delta row and delta column for neighbours
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1}; 
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor); 
        return ans;  
    }
    public static void main(String[] args)
    {
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        // sr = 1, sc = 1, newColor = 2       
        Solution obj = new Solution();
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

}
