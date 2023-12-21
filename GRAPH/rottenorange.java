class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public boolean isSafe(int row,int col,int grid[][]){
        if(row>=grid.length|| col>=grid[0].length || col<0 || row<0){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int ans[][]=new int[grid.length][grid[0].length];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    ans[i][j]=2;
                    q.offer(new Pair(i,j,0));
                }else{
                    ans[i][j]=grid[i][j];
                }
            }
        }
        int cnt=0;
        int drow[]={0,0,1,-1};
        int dcol[]={1,-1,0,0};
        while(!q.isEmpty()){
            
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair n = q.poll();
            cnt=n.time;
                int row=n.row;
                int col=n.col;
                int time=n.time;
                for(int r=0;r<drow.length;r++){
                    int nrow=row+drow[r];
                    int ncol=col+dcol[r];
                    if(isSafe(nrow,ncol,grid) && ans[nrow][ncol]==1){
                        ans[nrow][ncol]=2;
                        q.offer(new Pair(nrow,ncol,time+1));
                    }
                }
               // q.poll();
            }
        }
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                if(ans[i][j]==1){
                    return -1;
                }
            }
        }
        return cnt;
    }
}



//my solution with tle
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class rotten {
    public  static int orangesRotting(int[][] grid)
     {

       
                 Queue<node> x = new LinkedList<node>();
         int nonrotten =0;
         int rotten=0;
        int rootenlater=0;
        int time =Integer.MIN_VALUE;
         for(int i=0;i<grid[0].length;i++) // finding rotten
         {
             for(int j=0;j<grid[0].length;j++)
             {
                 if(grid[i][j] == 2)
                 {
                    node temp = create(i,j,0,true);
                    x.offer(temp);
                    rotten++;                  
                 }
                 if(grid[i][j] == 1)
                 {
                     nonrotten++;
                 }              
             }
         }  // end founding rotten nodes

         while (!x.isEmpty())
          {
            int s = x.size();
            for( int w=0;w<s;w++)
            {
                  node temp = x.poll();
            rootenlater++;           
            int a = temp.x;
            int b = temp.y;
            int time1 = temp.time;
            time = Math.max(time, time1);
            boolean v = temp.vis;
              //left
              if(safe(a, b-1,grid) == true)
              {
                node temp1 = new node(a, b-1, time1+1, true);
                x.offer(temp1);
              }
              //right
              if(safe(a,b+1,grid) == true)
            {
                 node temp2 = new node(a, b+1, time1+1, true);
                x.offer(temp2);
            }
             //up
              if(safe(a-1,b,grid) == true)
            {
                 node temp3 = new node(a-1, b, time1+1, true);
                x.offer(temp3);
            }
             //right
              if(safe(a+1,b,grid) == true)
            {
                 node temp4 = new node(a+1, b, time1+1, true);
                x.offer(temp4);
            }               
         }
            }
            
         if( rootenlater != ( rotten + nonrotten))
         return -1;
         return time;
       
    }
    public static  boolean safe(int a, int b, int [][]grid)
    {
        if( (a>=0 && a< grid.length) && ( b>=0 && b<grid[0].length))
        return true;
        else
        return false;
    }
    public  static node create(int x, int y, int time,boolean b)
    {
        node n = new node(x,y,time,b);
        return n;
    }

    public static void main(String args[])
    {
             int [][] grid = {{2,1,1},{0,1,1},{1,0,1}};
             int ans = orangesRotting(grid);
             System.out.println(ans);

    }
}
public  class node
{
    int x;
    int y;
    int time ;
    boolean vis = false;

    node(int x, int y, int time, boolean vis)
    {
        this.x =x;
        this.y =y;
        this.time = time;
        this.vis = vis;
      
    }
} 
