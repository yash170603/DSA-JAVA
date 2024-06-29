class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans= new ArrayList<>();
        List<List<Integer>> v= new ArrayList<>();

       for(int i=0;i<n;i++)
       {
        ans.add(new ArrayList<>());
        v.add(new ArrayList<>());
       }
        for( int arr[]:edges)
        {
            v.get(arr[0]).add(arr[1]);
        }    
        for(int a=0;a<n;a++)
        {
            boolean vis[]= new boolean [n];
            dfs(a,v,vis);
            for( int b=0;b<n;b++)
            {
                if( a==b)
                continue;
                else if( vis[b] == true)
                {
                    ans.get(b).add(a);
                }
            }
        }
        return ans; 
    }
    public void dfs( int node, List<List<Integer>> v, boolean [] vis)
    {
        vis[node]=true;
        for( int x: v.get(node))
        {
            if( !vis[x])
            {
                dfs( x, v, vis);
            }
        }
        return;
    }
}
