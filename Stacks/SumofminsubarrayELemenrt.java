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
/*Define a Pair Class:
The Pair class is defined to store two integers: currelement and countval. This class is later used to keep track of elements in the stack and their counts.

Create the Solution Class:
The Solution class contains the main logic for the problem.

Initialize a Modulus Constant:
The code defines a constant m which is set to (10^9 + 7). This constant will be used for modulus operations in the code.

sumSubarrayMins Method:
This is the main method that calculates the sum of subarray minimums for the given input array arr.

Create Two Stacks:
Two Stack<Pair> objects, s1 and s2, are created. These stacks will be used to store pairs of elements and their counts. s1 is for tracking elements to the left of the current element, and s2 is for tracking elements to the right of the current element.

Initialize Left and Right Arrays:
Two arrays, left and right, are created to store counts of elements less than or equal to the current element on the left and right sides, respectively. These arrays will be used to calculate subarray minimums.

Calculate Left Counts:
The code iterates through the input array arr from left to right. For each element, it checks the elements in the s1 stack. If the current element is smaller than the element at the top of the stack, it pops elements from the stack, and the count is accumulated. The current element is then pushed onto the stack along with the count. The count is stored in the left array for the current element's index.

Calculate Right Counts:
Similarly, the code iterates through the input array arr from right to left. It uses the s2 stack to accumulate counts for elements greater than or equal to the current element on the right side. The counts are stored in the right array.

Calculate Sum:
The code initializes a variable sum to 0. It then iterates through the input array arr one more time and calculates the contribution of each element to the final sum. The contribution is calculated as (arr[k] * left[k] * right[k]) % m, and this value is added to the sum.

Return the Sum:
The final sum is returned as the result of the sumSubarrayMins method.

The code effectively uses two stacks to keep track of counts of elements smaller than or equal to the current element on both the left and right sides. It then calculates the sum of subarray minimums based on these counts and returns the result. This algorithm is used to efficiently compute the sum of minimum elements in all possible subarrays of the given input array arr.*/
