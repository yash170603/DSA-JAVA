class Solution {
    public int majorityElement(int[] nums)
     {
         int c= nums[0];
         int cc=1;
         for( int i=1;i<nums.length;i++)
         {
               if( cc == 0)
           {
               c = nums[i];
               cc=1;
           }
            else if( nums[i]==c)
             { 
                 cc++;
             }      
             else
             {
                 cc--;
             }
           
         
         }
                   int veri=0;
         for(int k: nums)
         {
               if( k == c)
               {
                   veri++;
               }
         }

         if( veri>=nums.length/2)
        return c;

        return -1;
    }
}

//This Java code aims to find the majority element in an array. Here's the intuition behind how it works:  boyess morreee algorithm

//1. **Initialization**:
//    - The variable `c` is initialized to the first element of the array `nums`, assuming that it might be the majority element.
//    - The variable `cc` (count) is initialized to 1 because we have already seen one instance of the element `c`.

// 2. **Iterating through the Array**:
//    - The loop starts from the second element of the array and goes till the end.
//    - For each element in the array:
//      - If the current element (`nums[i]`) is equal to the assumed majority element `c`, increment the count `cc`.
//      - If the current element is not equal to `c`, decrement the count `cc`.
//      - If the count `cc` becomes 0, it means we've encountered a different element that has the same count as the current majority element `c`. In this case, we update `c` to the current element and reset the count `cc` to 1.

// 3. **Verifying the Majority Element**:
//    - After iterating through the array, it performs a verification step.
//    - It counts the occurrences of the assumed majority element `c` in the entire array.
//    - If the count of `c` is greater than or equal to half the length of the array, then `c` is considered the majority element, and it returns `c`.
//    - Otherwise, it returns `-1` indicating that there is no majority element.

// The algorithm is based on the fact that the majority element will occur more than `nums.length / 2` times in the array. The algorithm efficiently finds the majority element by canceling out each occurrence of different elements with the assumed majority element, resulting in a net positive count for the majority element. This is only possible if the majority element exists in the array.
