public class Solution {
    static boolean isKthBitSet(int n, int k) {


               boolean f = false;
               int x = 1<<(k-1);
            
               if((n|x)63 ==n)
               f = true;

               return f;
 

    }
}
