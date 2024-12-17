import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int limit) {
        StringBuilder ans = new StringBuilder();

        int n = s.length();
        PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> (b.ch - a.ch));  
        HashMap<Character, Integer> map = new HashMap<>();
         
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
         
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new node(entry.getKey(), entry.getValue()));
        }
 
       
         while (!pq.isEmpty()) {
            node curr = pq.poll(); 
            
            // a smart optimization --> i wan doing this from last iteration, as in what was the last len of string which was continuos, 
            // instead make sure that any string that gets prints greedily is always within limit first,

                int lastLen=0;
                while( curr.f>0 && lastLen<limit){
                    ans.append(curr.ch);
                    curr.f--;
                    lastLen++;
                }

                if( curr.f>0){  // add the next character.. for answer, and if the curr.f is >0 makes sense to add it in pq again, so not added above too
                        
                        // check if pq is empty, before adding next, if  adding the curr char was getting out of limit next shoudl be avaiable.
                        // if next is not available, curr toh waise bhi addd nhi hora abhi, aur next toh hai ni toh break kar jao/
                        // for eg, limit = 2, string was aa, and map has curr as  a->1
                         //cant add this a-> 1, plus iske badd pq is empty so break;

                       if(pq.isEmpty()) break;
                       node next= pq.poll();
                       ans.append( next.ch);
                       next.f--;

                       if( next.f>0) pq.offer(next);

                       pq.offer(curr);
                }
            }

            return ans.toString();

     
    }
}

class node {
    char ch;
    int f;
    
    node(char ch, int f) {
        this.ch = ch;
        this.f = f;
    }
}


// brrute force
import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int limit) {
        StringBuilder ans = new StringBuilder();

        int n = s.length();
        PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> (b.ch - a.ch));  
        HashMap<Character, Integer> map = new HashMap<>();
         
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
         
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new node(entry.getKey(), entry.getValue()));
        }
 
        while (!pq.isEmpty()) {
            node curr = pq.poll(); 
            if (ans.length() >= limit && ans.substring(ans.length() - limit).chars().allMatch(c -> c == curr.ch)) {
          
                if (pq.isEmpty()) break; 
                node next = pq.poll();
                ans.append(next.ch);
                next.f--;
                
           
                if (next.f > 0) {
                    pq.offer(next);
                }
             
                pq.offer(curr);
            } else {
             
                ans.append(curr.ch);
                curr.f--;
           
                if (curr.f > 0) {
                    pq.offer(curr);
                }
            }
        }

        return ans.toString();
    }
}

class node {
    char ch;
    int f;
    
    node(char ch, int f) {
        this.ch = ch;
        this.f = f;
    }
}
