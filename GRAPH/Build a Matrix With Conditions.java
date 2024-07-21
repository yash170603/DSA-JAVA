class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
          List<List<Integer>> adj1 = new ArrayList<>():
          fill(adj1,k);
          List<List<Integer>> adj2 = new ArrayList<>();
          fill(adj2,k);
          create(rowConditions,adj1);
          create(colCondtions,adj2);
          Stack<Integer> s1 = new Stack();
          Stack<Integer> s2 = new Stack();
          boolean vis1[]= new boolean[k+1];
          boolean vis2[]= new boolean[k+1];


          for( int p=1;p<=k;p++){
            if( ! vis1[p]){
                dfs( p, s1, adj1, vis1);
            }
          }


          for( int pp=1;pp<=k;pp++){
            if( ! vis2[pp]){
                dfs( pp, s2, adj2, vis2);
            }
          }

          List<integer> row = new ArrayList<>();
          List<Integer> col = new ArrayList<>();
          Set<integer> set = new HashSet<>();
          while( ! s1.isEmpty()){ // checking for cycles for a valid path 
            if(set.contains(s1.peek()))
            return new int[]{};
            row.add(s1.pop());
          }
          set = new HashSet<>();
           while( ! s2.isEmpty()){// checking for cycles for a valid path 
            if(set.contains(s2.peek()))
            return new int[]{};
           col.add(s2.pop());
          }
       HashMap<Integer,List<Integer>> map= new HashMap<>();
       int pointer=0;
       for( int t:row){
          if(map.get(t) == null){
            map.put(t, new ArrayList<>());
          }
          map.put(t, map.get(t));
       }


    }

    public void dfs(int index, Stack<Integer> s,  List<List<Integer>> adj, int [] vis ){
           vis[v] = true;
        for (int i : adj.get(index)) {
            if (!visited[i])
                topologicalSortUtil(i,s,adj,vis);
        }
        s.push(v);
    }

    public void create(int [] arr, List<List<Integer>> adj){
        for( int a[]:arr){
             adj.get(a[0]).add(a[1]);
          
        }
    }
    public void fill( List<List<Integer>> adj, int k){
        for( int i=1;i<=k;i++){
            adj.add(new ArrayList<>());
        }
    }
}
