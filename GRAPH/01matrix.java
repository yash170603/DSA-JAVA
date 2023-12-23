class Solution
{
        public int [][] updateMatrix(int [] [] mat)
    {
            int row = mat.length;
             int cols = mat[0].length;
             int vis [][] = new int [row][cols];
             int dis [][] = new int [row][cols];
             Queue <node> q = new LinkedList<>();
       for( int i =0;i< row ;i++)
          {
            for( int j=0;j<cols;j++)
             {
                if(mat[i][j] == 0)
                {
                 vis[i][j]=1;
                  q.offer( new node(i,j,0));                
                }
                else
                {
                    vis[i][j] =0;
                }
               
            }
          }
               while(!q.isEmpty())
                 {
                      for( int c =0; c< q.size();c++)
                       { 
                              int dr [] = { 1,-1,0,0};
                              int dc [] = {0,0,1,-1};
                              int xx = q.peek().x;
                              int yy = q.peek().y;
                              int distance = q.peek().dist;
                             dis[xx][yy] = distance;
                              q.poll();
                               for(int e =0;e<dr.length;e++)
                                 {
                                        int nrow = xx+dr[e];
                                        int ncol = yy+dc[e];
                                         if(safe( nrow, ncol, row, cols) == true && vis[nrow][ncol] ==0 )
                                              {
                                                          vis[nrow][ncol] =1;
                                                        q.offer(new node(nrow,ncol,distance+1));
                                              } // end of if
                                 }//end of dr for loop
                        } // end of for loop
                } //end of while loop
             return dis;
    }// end of main function
public boolean safe(int a, int b, int row, int cols )
{
   if( a<0 || b<0  || b>= cols  || a>= row)
    return false;
     return true;
} // end of safe
}// end of solution
class node
{
int x;
int y;
int dist;
public node(int x, int y, int dist)
{
    this.x = x; 
   this.y = y;
this.dist = dist;
}  // end of constructor
}// end of class node 

class Pair{
    int first;
    int second;
    int third;
    Pair(int one,int two,int three){
        this.first=one;
        this.second=two;
        this.third=three;
    }
}
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int n=mat.length;
//         int m=mat[0].length;
//         int[][]vis=new int[n][m];
//         int[][]dist=new int[n][m];
//         Queue<Pair>q=new LinkedList<>();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(mat[i][j]==0){
//                     q.add(new Pair(i,j,0));
//                     vis[i][j]=1;
//                 }else{
//                     vis[i][j]=0;
//                 }
//             }
//         }
//         int derow[]={-1,0,1,0};
//         int decol[]={0,1,0,-1};

//         while(!q.isEmpty()){
//             int row=q.peek().first;
//             int col=q.peek().second;
//             int step=q.peek().third;
//             q.remove();
//             dist[row][col]=step;

//             for(int i=0;i<4;i++){
//                 int nrow=row+derow[i];
//                 int ncol=col+decol[i];
//                 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
//                     vis[nrow][ncol]=1;
//                     q.add(new Pair(nrow,ncol,step+1));
//                 }
//             }

//         }

        
//     return dist;}
// }
