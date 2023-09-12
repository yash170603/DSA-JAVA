//1st 
class Solution {
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
   // and operator on 4 and 3 ==0, similarly for all 2 to the power n digits
    }
}


//2nd

//16/2=8,,,8/2=4,,4/2=2,2/2==1,,,,,
class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n <= 0) return false;

       while(n > 1 && (n % 2) == 0 ) {
            n /= 2;
        }

        return (n == 1 || n % 2 == 0)? true : false;
    }
}



//3rd
//All 2 to the power n have only 1 zero in bits sequence
passes 93.729 cases
  class Solution {
    public boolean isPowerOfTwo(int n) 
    {
         
         boolean f = false;
       
         int counter =0;


         if(n ==1)
         return true;

        


         
       if(n % 2 != 0)
       return false;

     
    
    for(int i=0;i<=(2^31-1);i++)
    {     
          int x =1;
         if((n &  (x<<i)) ==0)
         continue;

         else
         counter++;
          if (counter > 1)
                    return false; 
    }


    if(counter ==1)
    {
        f = true;
    }

return f;
    }
}
