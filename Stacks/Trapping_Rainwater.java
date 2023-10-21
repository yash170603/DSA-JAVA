// my solution
import java.util.Stack;
import java.util.*;
class Solution {
    public int trap(int[] arr)
     {
        int leftmax [] = new int[arr.length];
         int rightmax [] = new int[arr.length];
         int sum=0;

         leftmax = findleft(arr);

         rightmax = findright(arr);


         for(int p=0;p<arr.length;p++)
         {
             int a = leftmax[p];

             int b = rightmax[p];

           

             if(a!= -1 && b!= -1)
             {
                    int c = Math.min(a,b);
                    sum =  sum + (c-arr[p]);
             }

         }

           return sum;

    }

    public int [] findleft(int []arr)
    {
        Stack<Integer> s1 = new Stack<Integer>();
        int ans1[] = new int [arr.length];
        s1.push(arr[0]);
        ans1[0]= -1;

        for(int i=1;i<arr.length;i++)
        {
          
              if(arr[i] > s1.peek())
              {
                  ans1[i] = arr[i];
                  s1.push(arr[i]);
              }
              

              else
              {
                  ans1[i] = s1.peek();
              }
          
        }

        return ans1;

    }

    public int [] findright(int [] arr)
    {
         Stack<Integer> s2 = new Stack<Integer>();
        int ans2[] = new int [arr.length];
        s2.push(arr[arr.length-1]);
        ans2[arr.length-1]= -1;

        for(int i=arr.length-2;i>=0;i--)
        {
         
              if(arr[i] > s2.peek())
              {
                  ans2[i] = arr[i];
                  s2.push(arr[i]);
              }

              else
              {
                  ans2[i] = s2.peek();
              }
          
        }

        return ans2;
    }
}
