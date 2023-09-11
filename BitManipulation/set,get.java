//my approach , was wrong
import java.util.*;
public class Solution {
    public static int[] bitManipulation(int num, int i)
    {
        
 int n[]= new int[3];
        int sum=0;
        int sum2=0;
       ArrayList<Integer> x = new ArrayList<Integer>();

       int binary=0;

       while(num>=1)
       {
        binary = num%2;
        x.add(binary);
        num = num/2;
       }

     

     Collections.reverse(x);

       
         //prevsum
         int k =0;
       for(int j=x.size()-1;j>=0;j--)
       {
          
          sum += (x.get(j))*Math.pow(2,k);
          k++;
       }

        int v = x.get(i);
    
        x.set((x.size() -i), 1);
       

       
       //newsum
        int d =0;
       
       for(int l=x.size()-1;l>=0;l--)
       {
         
          sum2 += (x.get(l))*Math.pow(2,d);
          d++;
       }


       n[0] = v;
       n[2] = sum;
       n[1] = sum2;


       return n;

    }
}





//using bit manipulation
/*
    Time Complexity : O(1)
    Space Complexity : O(1)
*/
public class Solution {
    public static int[] bitManipulation(int num, int i){
        // Create a vector to store the results of the bit manipulation.
        int []ans = new int[3];

        // Initialize variables to store the results of the get, set, and clear operations.
        int get = 0, set = 0, clear = 0;

        // Create a mask with a 1 in the 'i'th position and 0s in all other positions.
        int mask = (1 << (i-1));

        // Check if the 'i'th bit in 'num' is set (i.e., equals 1) by using the bitwise AND operator with the mask.
        if((num & mask) != 0) {
            get = 1;
        }

        // Set the 'i'th bit in 'num' by using the bitwise OR operator with the mask.
        set = (num | mask);

        // Clear the 'i'th bit in 'num' by using the bitwise AND operator with the complement of the mask.
        clear = (num & (~mask));

        // Push the results of the 'get', 'set', and 'clear' operations to the vector.
        ans[0] = get;
        ans[1] = set;
        ans[2] = clear;

        // Return the vector containing the results.
        return ans;
    }
}
