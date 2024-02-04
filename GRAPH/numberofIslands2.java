//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    int rank [];
    int parent[];
    
    public List<Integer> numOfIslands(int row, int col, int[][] o) 
    {
        List<Integer> ans = new ArrayList<>();
        rank = new int [row*col];
        parent = new int [row*col];
        for( int i=0;i<row*col;i++)
        {
            rank[i]=1;
            parent[i]=i;
        }
        
       int mat [][]= new int [row][col];
        int vis [][]= new int [row][col];
       
                  int count =0;

       
       for( int arr [] : o)
       {
           int i = arr[0];
           int j = arr[1];
           mat[i][j] =1;
           if( vis[i][j] ==1)
           {
               ans.add( count);
               continue;
           }
           vis[i][j] =1;
           count ++;
           
           int [] r = {0,0,1,-1};
           int [] c = {1,-1,0,0};
           
           for( int a =0;a< r.length;a++)
           {
               int nrow = i+r[a];
               int ncol = j+c[a];
               if( nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && mat[nrow][ncol] == 1  )
               {
                    int v = find( i*col+j); // parent of current node
                    int vv =  find( nrow*col+ncol);    // parent of 4d adj node
                     if( v == vv)
                     continue;
                     if( v != vv)
                     {
                         union( v,vv);
                         count--;
                     }
                     
                    
               }
           }
           
           
           ans.add(count);
       }
        
        return ans;
       
       
    }
    public int find( int x)
    {
        if( parent[x] == x)
        return x;
        
        return parent[x] = find(parent[x]);
    }
    public void union( int x, int y)
    {
        int xp = find( x);
        int yp = find(y);
        if( xp == yp)
        return;
        
        if( rank[xp]>rank[yp])
        {
            parent[yp]=xp;
            rank[xp]++;
        }
        else if( rank[xp]< rank[yp])
        {
            parent[xp] = yp;
            rank[yp]++;
        }
        else
        {
          parent[yp]=xp;
            rank[xp]++;   
        }
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
