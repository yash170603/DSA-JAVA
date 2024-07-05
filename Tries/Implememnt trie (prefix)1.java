class Trie {
    nodes root;
    public Trie() {
        root= new nodes();
    }
    
    public void insert(String word) {
        root.insert(word,0);
    }
    
    public boolean search(String word) {
       return  root.search(word,0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix,0) ;
    }

    public class nodes{

        nodes [] arr;
        boolean isflag;

        nodes(){
              arr= new nodes[26];
              isflag=false;
        }
        public void insert( String word, int index)
        {
            if( index>=word.length())
            return;
            int  ch = word.charAt(index)-'a';
             if( arr[ch]==null)
                arr[ch]= new nodes();
             if( index == word.length()-1)
             arr[ch].isflag=true;
             arr[ch].insert(word,index+1);
        }

        public boolean search( String word, int index)
        {
            if( index >= word.length())
            {
                 return false;
            }
            int ch= word.charAt(index)-'a';
            if( arr[ch]==null) return false;
            if(index==word.length()-1 && arr[ch].isflag) return true;
            return arr[ch].search(word,index+1);
        }
        public boolean startsWith(String word,int index)
        {
            if( index >= word.length())
            {
                 return false;
            }
            int ch= word.charAt(index)-'a';
            if( arr[ch]==null) return false;
            if(index==word.length()-1) return true;
            return arr[ch].startsWith(word,index+1);
        }

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
