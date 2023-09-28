/*The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}








//2nd for 1 array oonly


import java.util.Stack;
import java.util.HashMap;
public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n)
     {
      Stack<Integer> s1 = new Stack<Integer>();
    HashMap<Integer,Integer> x = new HashMap<Integer,Integer>();
    
    int ans[] = new int [n];
    

    for(int i= n-1;i>=0;i--)
    {
        while(s1.isEmpty()!= true && s1.peek()<= arr[i])
        {
            s1.pop();
            
        }
x.put(arr[i], s1.isEmpty() ? -1 : s1.peek());
       
        s1.push(arr[i]);
        
    }

    for(int h=0;h<ans.length;h++)
    {
        ans[h] = x.getOrDefault(arr[h]);
    }

    return ans;
//  int[] ans = new int[n];

//         // Stack, to keep track of next greater element
//         Stack<Integer> s = new Stack<Integer>();

//         // Traverse in reverse fashion in the array
//         for(int i = n - 1; i >= 0; i--)
//         {
//             // If current element is greater than or equal to stack's top 
//             // element, we can pop it since now it will never get picked
//             // as the next greater element
//             while(!s.empty() && arr[i] >= s.peek())
//             {
//                  s.pop();
//             }

//             // If stack is not empty, stack's top element is 
//             // the next greater element, else there is none
//             if(!s.empty())
//             {
//                 ans[i] = s.peek();
//             }
//             else
//             {
//                 ans[i] = -1;
//             }

//             // Push current element onto stack
//             s.push(arr[i]);
//         }

//         // return final answer vector
//         return ans;
      
    }
}
