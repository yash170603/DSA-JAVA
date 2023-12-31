// // cp way
// The provided code implements a solution for finding all possible shortest transformation sequences from a given
//   start word to an end word using a list of valid words. The code uses a breadth-first search (BFS) approach to explore
//   possible word transformations and then performs a depth-first search (DFS) to reconstruct and collect all valid sequences.
// Here's a summary of the approach and its time complexity:
// 1. **Breadth-First Search (BFS):**
//    - A queue (`q`) is used to perform BFS. The initial word (`beginword`) is enqueued.
//    - The code iterates through the queue, generating all possible one-character variations of the current word and checking if they exist in the wordlist.
//    - If a valid word is found, it is added to the queue for further exploration, and its level (distance from the start word) is recorded in the `mapp` HashMap.
//    - The process continues until the endword is found or the queue is empty.
// 2. **Depth-First Search (DFS):**
//    - If the endword is in the wordlist (i.e., reachable), the DFS is initiated from the endword.
//    - The DFS explores all possible paths by considering one-character variations of the current word and checking if
//   they are at the correct level in the BFS traversal.
//    - Valid sequences are collected and added to the `ans` list.
// **Time Complexity:**
// - The BFS phase explores the word space in a breadth-first manner. In the worst case, each word generates O(N)
//   variations (where N is the length of the word), and there are O(M) words in the wordlist.
// - The DFS phase explores the word space in a depth-first manner, considering all possible paths.
// - Therefore, the overall time complexity is O(M * N) for the BFS phase and potentially worse for the DFS phase, 
//   leading to an overall time complexity of O(M * N).
// Note: The actual performance may vary based on the characteristics of the input wordlist and the specific words involved
//   . Additionally, constant factors and optimizations may influence the practical performance.
class Solution {
     String b;
    List<List<String>> ans;
    HashMap< String, Integer> mapp ;
    HashSet<String> set;
    public List<List<String>> findLadders(String beginword, String endword, List<String> wordlist) 
    {
        set = new HashSet<>();

        for( int i =0; i<wordlist.size();i++)
        {
             set.add(wordlist.get(i));
        }
       ans = new ArrayList<>();
       Queue<String> q = new LinkedList<>();    //contains strings
       b = beginword;
       set.remove(b);
       q.offer(b);
       mapp = new HashMap<>();
       mapp.put(b,1);

       while( !q.isEmpty())
       {

         String s = q.peek();
         int level = mapp.get(s);
         int sz = s.length();
         if( s.equals(endword))
         break;
         for( int a = 0;a<sz;a++)
         {
            char c[] = s.toCharArray();
            for( char ch = 'a';ch<='z';ch++)
            {
                c[a] = ch;
                String newword = new String(c);
                if(wordlist.contains(newword))
                {
                    q.offer(newword);
                    set.remove(newword);
                    mapp.put(newword, level+1);
                }
            }
           }
       }     
       if( set.contains(endword))
       {
           List<String> word = new ArrayList<>();
           word.add(endword);
           dfs(endword, word);
       }
        return ans;
        
    }
    public void dfs(String w,List<String>temp)
    {
        if( w.equals(b))
        {
            List<String> dup = new ArrayList<>(temp);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int lvel = mapp.get(w);
        int size = w.length();
        for( int k =0;k<size;k++)
        {
             char g [] = w.toCharArray();
            for( char f ='a';f<='z';f++)
            {
               g[k] =f;
               String b = new String(g);
               if( mapp.containsKey(b) && mapp.get(b)+1 == lvel)
               {
                temp.add(b);
                dfs(b, temp);
                temp.remove(temp.size()-1);

               }


            }
        }
        
    }
}

// normal way
/*The provided code also attempts to find all possible shortest transformation sequences from a given start
word to an end word using a list of valid words. It uses a BFS approach with a queue to explore possible word transformations.
Here's a summary of the approach and its time complexity:

Breadth-First Search (BFS):

A queue (q) is used to perform BFS. The initial word (beginword) is enqueued.
The code iterates through the queue, generating all possible one-character variations of the current word and checking if they exist in the wordlist.
If a valid word is found, it is added to the queue for further exploration.
The process continues until the endword is found or the queue is empty.
Node Class:

A node class is defined to represent a sequence of words (path) from the start word to the current word.
Time Complexity:

Similar to the previous implementation, the BFS phase explores the word space in a breadth-first manner.
In the worst case, each word generates O(N) variations (where N is the length of the word), and there are O(M) words in the wordlist.
The overall time complexity is O(M * N) for the BFS phase.*/
class Solution {
    public List<List<String>> findLadders(String beginword, String endword, List<String> wordlist) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordlist.contains(endword)) {
            return ans;
        } else {
            List<String> head = new ArrayList<>();
            head.add(beginword);
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(head));
            
            while (!q.isEmpty()) {
                List<String> prevlevel = new ArrayList<>();
                List<String> temp = q.peek().temp;
                int listsize = temp.size();
                q.poll();
                String operated = temp.get(listsize - 1);
                
                if (operated.equals(endword)) {
                    break;
                }

                for (int i = 0; i < operated.length(); i++) {
                    char[] ch = operated.toCharArray();
                    for (char r = 'a'; r <= 'z'; r++) {
                        ch[i] = r;
                        String newword = new String(ch);
                        if (wordlist.contains(newword)) {
                            prevlevel.add(newword);
                            List<String> o = new ArrayList<>();
                            o.addAll(temp);
                            o.add(newword);
                            q.offer(new Node(o));
                        }
                    }
                }
            }

            while (!q.isEmpty()) {
                Node f = q.poll();
                ans.add(f.temp);
            }

            return ans;
        }
    }
}

class Node {
    List<String> temp;
    public Node(List<String> temp) {
        this.temp = temp;
    }
}
