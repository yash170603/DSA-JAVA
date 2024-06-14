import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
   
   if( s.length()==0)
   return 0;

        HashSet<Character> x = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int len=0;
        int i =0,j=0;
       
        while(i<s.length())
            {
              
                 if( x.contains(s.charAt(i)))
                 {
                      while(x.contains(s.charAt(i)) )
                {
                    x.remove(s.charAt(j));
                    len--;
                    j++;
                }  
                 }
              

                x.add(s.charAt(i));
                len++;
                i++;
                  ans = Math.max(ans,len);
                 

              
            }

        return ans;
    }
} 
