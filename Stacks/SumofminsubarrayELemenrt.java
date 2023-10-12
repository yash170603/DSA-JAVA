//this is to be understood passes 87//87 cases
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        long M = (long)1e9 + 7;
        stack.push(-1);
        
        for (int i2 = 0; i2 < arr.length+1; i2++){
            int currVal = (i2<arr.length)? arr[i2] : 0;
            
            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long add = (long)(left * right * (long)arr[index]) % M;
                res += add ;
                res %= M;
            }
            
            stack.push(i2);
            
        }
        
        return (int)res;
        
    }
}







// what i learned 86/87 cases passed 
import java.util.*;
class Pair
{
    int currelement;
    int countval;

    Pair(int curr, int count)
    {
        currelement = curr;
        countval = count;
    }
}
class Solution 
{
public int m = (int) Math.pow(10, 9)+7;
    public int sumSubarrayMins(int[] arr)
     {
        
       
       Stack<Pair> s1 = new Stack<>();
       Stack<Pair> s2 = new Stack<>();
        
        int left [] = new int[arr.length];
        int right [] = new int [arr.length];

        for(int i=0;i<arr.length;i++)
        {
            int current = arr[i];
            int count =1;

            while( !s1.isEmpty() && s1.peek().currelement > current )
            {
                count = count + (s1.peek().countval);
                s1.pop();
            }

           s1.push( new Pair(current, count));
            left[i] = count;

        }


          for(int j=arr.length-1;j>=0;j--)
        {
            int current = arr[j];
            int count =1;

            while( !s2.isEmpty() && s2.peek().currelement >= current )
            {
                count = count + (s2.peek().countval);
                s2.pop();
            }

          s2.push( new Pair(current, count));
            right[j] = count;

        }
int sum =0;

        for( int k =0;k<arr.length;k++)
        {


             sum = (sum + (arr[k]*left[k] * right[k]))%m;


        }
       return sum;
        
    }
}
