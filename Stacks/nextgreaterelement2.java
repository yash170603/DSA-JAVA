import java.util.Stack;
class Solution {
    public int[] nextGreaterElements(int[] nums)
     {


//  int n = nums.length;
//         int[] ans = new int[n];
//         Stack<Integer> s = new Stack<>();

//         for(int i = 2*n-1; i >= 0; i--) {
//             while(!s.isEmpty() && s.peek() <= nums[i % n]) {
//                 s.pop();
//             }

//             if(i < n) {
//                 if(!s.isEmpty()) {
//                     ans[i] = s.peek();
//                 } else {
//                     ans[i] = -1;
//                 }
//             }

//             s.push(nums[i % n]);
//         }

//         return ans;/

int ans [] = new int [nums.length];
Stack<Integer> s1 = new Stack<Integer>();

for(int k= nums.length-1;k>=0;k--)
{
    s1.push(nums[k]);
}

     for(int j = nums.length-1;j>=0;j--)
     {
         while(!s1.isEmpty()  && s1.peek()<= nums[j])
         {
             s1.pop();
         }

         if(s1.isEmpty() == false)
         {
             ans[j] = s1.peek();
         }
         else
         {
             ans[j] = -1;
         }

         s1.push(nums[j]);
     }


 return ans;











    }
}
