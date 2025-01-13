 
//   so the thing is we are making a trie like this 
    
//       suppose if a words was abcab,  remeber this abcab was the last word in the test case [ ab, abcab], we going ulta
//        then trie will be like this, i.e liek incrementing the pseudo count , as any word is its own suffix and prefix, so we build and define the count at once.
           
//            (a,b)  c=1
//              |
//              v
//            (b,a)  c=1
//              |
//              v
//            (c,c)  c=1
//              |
//              v
//            (a,b)   c=1
//              |
//              v
//            (b,a)    c=1


//              , then if the , the next word is ab

//               then ab would be inserted like
                
//                 (a,b) c=1
//                   |
//                   v
//                 (b,a) c=1
//                    combining these two 

           
//            (a,e) c=1              (a,b) c=1                (a,b) c=2
//              |                      |                        |
//              v            +         v           ->           v
//            (b,d)  c=1             (b,a) c=1                 (b,a) c=2   . ,,  at this node, the ab, is inserted, 
//              |                                                |
//              v                                                v
//            (c,c) c=1                                        (c,c) c=1   . the curr will be here, meaning only one word before u has traveled tll here, so you are its( the node which has traveled before suffix as well as prefix )
//              |                                                |
//              v                                                v
//            (d,b) c=1                                        (d,b) c=1
//              |                                                |
//              v                                                v
//            (e,a)  c=1                                       (e,a)  c=1

             
 


class Solution {
    public long countPrefixSuffixPairs(String[] words) {
          
           Trie root = new Trie();
            int n = words.length;
            long ans=0;
             for( int i=n-1; i>=0;i--){
                  ans+= root.count(words[i]);
                  root.add(words[i]);
             }

             return ans;
    }
}
class Trie{
       
       TrieNode root;

        Trie(){
              root = new TrieNode();
        }

         public void add(String s){
               TrieNode curr = root;
                   int n = s.length();
                 for( int i=0;i<n; i++){
                          char first = s.charAt(i);
                        char last = s.charAt( n-i-1);
                          List<Character> key = Arrays.asList(first,last);
                           curr.map.putIfAbsent(key, new TrieNode());
                           curr = curr.map.get(key);
                           curr.count++;      
                 }
         }

         public int count( String s){
               TrieNode curr = root;
                int n = s.length();
                 for( int i=0; i< n;i++){
                         char first = s.charAt(i);
                          char last = s.charAt(n-i-1);
                           List<Character> key = Arrays.asList(first,last);
                            if( curr.map.get(key) == null) return 0;
                            curr = curr.map.get(key);
                 }
                  return curr.count;
         }
    
}

class TrieNode{

       Map<List<Character>, TrieNode> map;
        int count;
         
         TrieNode( ){
             map = new HashMap<>();
              count =0;
         }
}

 
