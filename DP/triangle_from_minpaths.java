class Solution {
    int dp [][];
    public int minimumTotal(List<List<Integer>> tri) {
         
         if( tri.size() ==1)
         {
            List<Integer> t = tri.get(0);
            Collections.sort(t);
            return t.get(0);
         }
         int n = tri.size();
        dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

         
         int ans =0;
         ans = solve(0,0,tri);
         return ans;
    }

    public int solve( int index, int gridindex,List<List<Integer>> tri)
    {
        if (dp[index][gridindex] != -1)
            return dp[index][gridindex];

        int rows = tri.size();
      int res=0;
     
        if( gridindex == rows-1)
        {
            List<Integer> temp = tri.get(gridindex);
             res = temp.get(index);
            return res;
        }
        int sameindex=0;
         int nextindex=0;
      sameindex = solve(index,gridindex+1,tri);
       nextindex = solve(index+1,gridindex+1,tri);

   return dp[index][gridindex]= tri.get(gridindex).get(index)+Math.min(sameindex,nextindex);



    }
}
