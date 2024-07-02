class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;

        for(int x: bills)
        {
            if( x ==5)
            {
                five++;
            }
            else if ( x==10)//returning 5
            {
               if( five>=1)
               {
                    five--;
                   ten++;
               }
              

               else
               return false;
            } 

            else  // x == 20, two cases 1 10,1 5 or 3 5
            {
                if( ten>=1 && five>=1)
                {
                    ten--;
                    five--;
                }
                else if(five>=3)
                {
                    five-=3;
                }
                else
                return false;
            }

        }
        return true;
    }
}
