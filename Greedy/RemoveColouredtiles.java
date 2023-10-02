//THIs question was supposed to be done by greedy method, but i solved by my own method, Still a lucky guess..
// This is greedy which i will study later
public class Solution {
    public boolean winnerOfGame(String colors) {
        Map<Character, Integer> c = new HashMap<>();
        c.put('A', 0);
        c.put('B', 0);
        
        for (int i = 0; i < colors.length(); i++) {
            char x = colors.charAt(i);
            int count = 0;
            
            while (i < colors.length() && colors.charAt(i) == x) {
                i++;
                count++;
            }
            
            c.put(x, c.get(x) + Math.max(count - 2, 0));
            i--;
        }

        return c.get('A') > c.get('B');
    }
}


/// This IS my solution which worked too
class Solution {
    public boolean winnerOfGame(String c) 
    {
        boolean f= false;
        if(c.length() > Math.pow(10,5))
        return f;
        
            if(c.length() <3)
            {
                f=false;
            }
            
            //String s1 = colors.substring(0,colors.length());


          int count_a=0;
          int count_b=0;

             

             for(int i=1;i<c.length()-1;i++)
             {
                 char first =c.charAt(i-1);
                 char second=c.charAt(i);
                 char third=c.charAt(i+1);
                 if(  (first == 'A') && (second == 'A') && (third == 'A'))
                 {
                     count_a++;
                 }
                  else if( (first == 'B') && (second == 'B') && (third == 'B'))
                 {
                     count_b++;
                 }

                 else
                 {
                     continue;
                 }

             }

if(count_a> count_b)
{
    f= true;
}





            return f;
    }
}
