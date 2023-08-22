// Given an integer array nums that may contain duplicates, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 


   
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums)
     {
         int i =0;
        Arrays.sort(nums);
        ArrayList<Integer> b = new ArrayList<>(); //stores 1 subset
        List<List<Integer>> a = new ArrayList<>();// stores power set
        subset(nums,i,a,b);
        HashSet<List<Integer>> set = new HashSet<>(a);

        // Convert the HashSet back to a List
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

     public   void subset(int  [] nums,  int i, List<List<Integer>> a, ArrayList<Integer> b )
    {

        if( i == nums.length)
        {
            a.add(new ArrayList<>(b));

            return;
        }

        b.add(nums[i]);
        subset(nums,i+1,a,b);
        b.remove(b.size() -1);
        subset(nums,i+1,a,b);



    }
}
