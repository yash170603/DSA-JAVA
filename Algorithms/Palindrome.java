import java.util.*;         // 99.99 percent cases passed.

class Solution {
    public boolean isPalindrome(int x)
     {
        int v = x;
        boolean f= false;
         int counter=0;
        String s = String.valueOf(v);

        int i =0;
        int j = s.length()-1;

        while( i <=j)
        {
            if(s.charAt(i) == s.charAt(j))
            counter++;
            i++;
            j--;
        }
  
  if(counter >= (s.length())/2)
  f = true;


  return f;


        
    }
}
