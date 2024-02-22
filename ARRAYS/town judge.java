// my approach passed 87/92
class Solution {
    public int findJudge(int n, int[][] trust)
     {
        int arr [] = new int [n+1];
        Arrays.fill(arr,0);
        int ans =-1;
        for( int x[] : trust)
        {
            int a =x[0];
            int b = x[1];
            arr[a]=1;
        }

        for( int i=1;i< arr.length;i++)
        {
            if( arr[i] == 0)
            {
                ans= i;
            }
        }

        return ans;
    }
}

// outdegree and indegree
import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        
        for (int[] vec : trust) {
            indegree[vec[1]]++;
            outdegree[vec[0]]++;
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0)
                return i;
        }
        
        return -1;
    }
}

//
//i dont get why we decrease 
import java.util.Arrays;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];

        // Count the number of people trusting each person
        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            trustCount[a]--;
            trustCount[b]++;
        }

        // Find the person trusted by everyone except themselves
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        return -1; // No town judge found
    }
}
