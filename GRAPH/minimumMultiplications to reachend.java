//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

       if( start == end) return 0;
        int steps []= new int[100000];
        for( int i=0;i<100000;i++)steps[i]=(int)1e9;
        steps[start]=0;
        int mod = 100000;
        Queue<node> q = new LinkedList<>();
        q.offer( new node( 0,start));
        while(! q.isEmpty())
        {
            int step = q.peek().first;
            int val= q.peek().second;
            q.poll();
            
            for( int w =0;w<arr.length;w++)
            {
                int nval = (val*arr[w])%mod;
                if( step+1< steps[nval])
                {
                    steps[nval]= step+1;
                    if( nval == end) return step+1;
                    q.offer(new node( step+1, nval));
                }
            }
        }
        
         return -1;
    }
}
class node
{
    int first;
    int second ;
    node( int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
