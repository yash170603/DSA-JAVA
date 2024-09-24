class Solution {
    TrieNode instance;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        instance = new TrieNode();
         for( int s : arr1){
            insert(String.valueOf(s));
        }

          int ans = 0;
        
          for( int u: arr2){
             int length = search(String.valueOf(u));
             ans = Math.max(length, ans);
          }

        return ans;
    }

     public void insert( String x){
        TrieNode copyInstance = instance;
        for( char ch : x.toCharArray()){
              copyInstance.body.putIfAbsent(ch,new TrieNode());
              copyInstance= copyInstance.body.get(ch);
        }
    }
    public int search( String x ){

        int maxLength = 0;
       
        TrieNode copyInstance = instance;
         
       for( int i =0;i< x.length();i++){
             char ch = x.charAt(i);
             if( copyInstance.body.containsKey(ch)){
                maxLength=i+1;
                copyInstance=copyInstance.body.get(ch);
             }
             else {
                break;
             }
       }
        return maxLength;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> body;

    TrieNode() {
        body = new HashMap<>();
    }
}
