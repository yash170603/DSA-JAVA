class Solution {
    public int removeStones(int[][] stones)
     {
        int vis[]= new int[stones.length];
        int count =0;
        int n= stones.length;
        for( int i=0;i<n;i++)
        {
            if( vis[i] == 1)
            continue;
            dfs(i,vis,stones);
            count++;
        }
      return n-count;
    }
    public void dfs(int index, int vis[],int [][] stones)
    {
        vis[index]=1;
        int [] temp = new int[2];
        temp=stones[index];
        int pr = temp[0];
        int pc = temp[1];

        for( int k=0;k<stones.length;k++ )
        {
            if( vis[k] !=1)
            {
                 int aa = stones[k][0];
                 int bb = stones[k][1];
                 if( pr == aa || pc == bb)
                 {
                     dfs( k, vis, stones);
                 }
            }
        }
    }
}
