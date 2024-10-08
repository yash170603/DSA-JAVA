
class Solution {
    HashSet<String> set;
    
    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>();

        // Add all dictionary words to the set for quick lookup
        for (String word : dictionary) {
            set.add(word);
        }

        // Length of the string
        int n = s.length();

        // DP array to store the minimum extra characters needed up to each index
        int[] dp = new int[n + 1];

        // Initialize the dp array with a large value (to simulate infinity)
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Base case: no extra characters are needed for an empty string
        dp[0] = 0;

        // Iterate over each index of the string
        for (int i = 1; i <= n; i++) {
            // Check all possible substrings ending at index `i-1`
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);

                // If the substring exists in the dictionary, no extra characters are needed for this part
                if (set.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    // Otherwise, add the length of the substring as extra characters
                    dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            }
        }

        // The answer will be stored in dp[n], which gives the minimum extra characters for the whole string
        return dp[n];
    }
}




class Solution {
    HashSet<String> set ;
    HashMap<String,Integer> map ;
    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>();
        map= new HashMap<>();

        for(String x : dictionary){
            set.add(x);
        }
        return solve(s);
    }
    public int solve( String s){
         
       if( !set.contains(s) && s.length() ==1) return 1;
       if( set.contains(s)) return 0;

           if( map.containsKey(s)) return map.get(s);
           int ans = Integer.MAX_VALUE;
          for( int i =1;i<s.length();i++){
              int a  = solve( s.substring(0,i));
              int b = solve(s.substring(i));
              ans= Math.min( ans, a+b);
          } 

          map.put( s,ans);

          return ans;
    }
}


// trie solutioon
class Node{
    public Node[] child;
    public boolean isEnd;
    public Node(){
        child = new Node[26];
        isEnd = false;
    }
}
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Node root = new Node();
        for(String str: dictionary){
            insert(str, root);
        }
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i = 0; i < n+1; i++){
            dp[i] = i;
        }

        for(int i = 0; i < n; i++){
            search(s, root, i, dp);
            dp[i+1] = Math.min(dp[i+1], dp[i]+1);
        }
        return dp[n];
    }
    public void insert(String s, Node root){
        for(int i = 0; i < s.length(); i++){
            int path = s.charAt(i) - 'a';
            if(root.child[path] == null){
                Node node = new Node();
                root.child[path] = node;
            }
            root = root.child[path];
        }
        root.isEnd = true;
    }
    public void search(String s, Node root, int idx, int[] dp){
        for(int i = idx; i < s.length(); i++){
            int path = s.charAt(i) - 'a';
            if(root.child[path] != null){
                root = root.child[path];
                if(root.isEnd){
                    dp[i+1] = Math.min(dp[i+1], dp[idx]);
                }
            } else {
                return;
            }
        }
    }
}
