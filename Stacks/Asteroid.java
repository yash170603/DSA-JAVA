//passed 210 cases
import java.util.*;
import java.util.Stack;
class Solution {
    public int[] asteroidCollision(int[] arr)
     {
        Stack<Integer> x = new Stack<Integer>();
        ArrayList<Integer> x1 = new ArrayList<Integer>();
       // int  ans [] = new int[x1.size()]; 
         x.push(arr[0]);


        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<0 && x.peek()<0)
            {
                x.push(arr[i]);
            }

            else if( arr[i]>0 && x.peek()<0)
            {
                x.push(arr[i]);

            }
              else if( arr[i]>0 && x.peek()>0)
            {
                x.push(arr[i]);
                
            }

            else
            {
                  int a = Math.abs(arr[i]);
                  int count =0;
                while(!x.isEmpty() && x.peek() >0)
                {  
                  
                    if( a == Math.abs(x.peek()) && count ==0)
                   {
                         x.pop(); 
                    count++;
                   }
                    else if(a> Math.abs(x.peek())   && count ==0)
                    x.pop(); 
                    
                    else
                    {
                        break;
                    }             
                }
                 
               
                  if(x.isEmpty()==true )
                 {
                     break;
                 }
                
                 
              if( x.peek() <0 && count==0)
              {
                  x.push(arr[i]);
              }

              
            }
        }


       while( !x.isEmpty())
         {
            x1.add(x.pop());
         }

         Collections.reverse(x1);

         int ans [] = new int [x1.size()];
       for(int k =0;k<ans.length;k++)
       {
        ans [k] = x1.get(k);
       }
   return ans;
        
    }
}








//leetcode 
class Solution {
    public boolean samesign(int x, int y) {
        if (x < 0 && y < 0)
            return true;
        else if (x > 0 && y > 0)
            return true;
        return false;
    }

    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.size() == 0 || (st.peek() < 0 && a[i] > 0) || samesign(st.peek(), a[i])) {
                st.push(a[i]);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(a[i]))
                    st.pop();

                if (st.size() == 0 || st.peek() < 0) {
                    st.push(a[i]);
                } else if (st.peek() == Math.abs(a[i])) {
                    st.pop();
                }
            }
        }

        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            ans[i] = st.peek();
            i--;
            st.pop();
        }
        return ans;
    }
}
