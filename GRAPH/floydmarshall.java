//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        
           for(int ii = 0; ii<n; ii++) {
            for(int ji = 0; ji<n; ji++) {
                
                if(matrix[ii][ji] == -1)
                    matrix[ii][ji] = 100000;
                
            }
        }
        
        
        for( int i=0;i<n;i++)
        {
            for( int j=0;j<n;j++)
            {
                for( int k=0;k<n;k++)
                {
                    if( matrix[j][k] > matrix[j][i]+matrix[i][k])
                    {
                        matrix[j][k] = matrix[j][i]+matrix[i][k];
                    }
                    //matrix[j][k]= Math.min(matrix[j][k],matrix[j][i]+matrix[i][k]);
                }
            }
        }
        
           for(int a = 0; a<n; a++) {
            for(int ja = 0; ja<n; ja++) {
                
                if(matrix[a][ja] == 100000)
                    matrix[a][ja] = -1;
                
            }
        }
    }
}
