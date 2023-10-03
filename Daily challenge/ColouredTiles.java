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
