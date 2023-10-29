//my approach 20/98 cases
import java.util.ArrayList;
import java.util.*;
import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] nums) 
    {
          Stack<Integer> s= new Stack<Integer>();
           ArrayList<Integer> x = new ArrayList<>();

        if(nums.length == 0)
        {
            return 0;
        }
        if(nums.length == 1)
        {
            return nums[0];
        }
         if(nums.length == 2)
        {
            if( nums[0] ==0 ||  nums[1]==0)
            {                   
                int a =  nums[0];
                int b=  nums[1];
                if(a == 0)
                return b;
                else
                return a;
            }
            else if (  nums[0]== nums[1])
            {
                return  nums[0]*2;
            }
            else 
            {
                      int h = nums[0];
            int u = nums[1];
            int f = Math.min(h, u);
            return f*2;
            }
        }       
        for( int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length-1;j++)
            {                
                 s.push(nums[i]);
                 int sum = nums[i];
                 int sum1 =0;
                 Stack<Integer> temp = new Stack<Integer>();
                 if(nums[j] >= s.peek())
                 {
                    sum += sum;
                 }
                 else if(nums[j]>= s.peek() && s.peek() == 0)
                 {
                     sum = nums[j];
                 }
                 //first smaller element comes
                 else if(  temp.isEmpty() == true && nums[j] < s.peek())
                 {
                    sum1 = nums[j] * ((j+1)-i);
                    temp.push(nums[j]);
                 }
                 else if( nums[j] == 0)
                 {
                     if(temp.isEmpty() == true)
                     {
                      sum1 = sum;
                     break;
                     }  
                     else
                     {
                         sum1 = temp.peek()*(j-i-1);
                     }
                 }
                 else if(nums[j] > temp.peek()  && temp.isEmpty() == false)
                 {
                    sum1 = sum1+ temp.peek();
                 }
                 else
                 {
                    sum1 = nums[j] * ((j+1) -i);
                    temp.push(nums[j]);

                 }
                 x.add(Math.max(sum, sum1));
                 temp.removeAllElements();
            }
        }
            Collections.sort(x);
            int ans = x.get(x.size()-1);
            return ans;
    }
}



//
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, area = 0;

        // Find the next smaller left -->
        Stack<Integer> s = new Stack<>();
        int[] nsl = new int[n];
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(!s.isEmpty()) {
                nsl[i] = s.peek();
            } else {
                nsl[i] = -1;
            }

            s.push(i);
        }


        // Find the next smaller right -->
        s = new Stack<>();
        int[] nsr = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(!s.isEmpty()) {
                nsr[i] = s.peek();
            } else {
                nsr[i] = n;
            }

            s.push(i);
        }


        // Calculating the area of Histogram -->
        for(int i = 0; i < n; i++) {
            int hei = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = hei * width;
            area = Math.max(area, currArea); 
        }

        return area;
    }
}
