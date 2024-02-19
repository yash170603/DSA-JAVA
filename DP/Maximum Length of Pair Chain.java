class Solution {   bottom up
    public int findLongestChain(int[][] pairs) 
    {
          int n = pairs.length;
          Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] t = new int[n];
        Arrays.fill(t,1);
    
        int maxLIS = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] <pairs[i][0]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }

        return maxLIS;
    }
}
 // top down worse
 class Solution {
    
     int dp [][] = new int [1001][1001];
     public int findLongestChain(int[][] pairs)
      {
          Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
          for( int arr[]:dp)
          {
              Arrays.fill(arr,-1);
          }
          int n = pairs.length;

       return     solve(0,-1,pairs,n);
         
        
     }

    
     
    public int solve( int index, int prev, int [][] pairs, int n)
     {
         if(  index >= n)
         return 0;

         if( prev !=-1 && dp[index][prev] !=-1)
         return dp[index][prev];
  

   int take=0;
         if(prev == -1 || pairs[index][0]> pairs[prev][1])
         {
            take =1+ solve( index+1,index,pairs,n);
         }

         int skip = solve( index+1, prev, pairs,n);

         if( prev != -1)
         {
             dp[index][prev] = Math.max( take,skip);
         }

         return  Math.max( take,skip);
     }
     
 }
