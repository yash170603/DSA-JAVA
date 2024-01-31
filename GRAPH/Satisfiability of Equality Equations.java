class Solution {
  int rank[];
  int parent [];
    public boolean equationsPossible(String[] e) 
    {
        rank = new int [26];
        parent = new int[26];
        for( int k=0;k<26;k++)
        {
            rank[k]=0;
            parent[k]=k;
        }
         for(String s : e) {
            if(s.charAt(1) == '=')
                union(s.charAt(0)-'a', s.charAt(3)-'a');
        }
        
        for(String ss : e) {
            if(ss.charAt(1) == '!') {
                if(find(ss.charAt(0)-'a') == find(ss.charAt(3)-'a'))
                    return false;
            }
        }
        
        return true;

    }

     public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

     public int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }


}
