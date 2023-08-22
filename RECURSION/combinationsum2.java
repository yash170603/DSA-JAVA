//find targetsum and the combinations should not be repated
import java.util.*;
class Untitled
{
    public static void main(String args [])
    {
        int [] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> h = combinationSum2( nums,  target);
      for( List<Integer> g :h)
        {
            System.out.print(g +" ");
        }



    }
    public static List<List<Integer>> combinationSum2(int[] nums, int target)
     {
        
        int i =0;
        int sum=0;
        Arrays.sort(nums);
        List<Integer> b = new ArrayList<>();
        List<List<Integer>> a = new ArrayList<>();
        calci(nums,target,sum,i,a,b);

        HashSet<List<Integer>> set = new HashSet<>(a);

        // Convert the HashSet back to a List
        List<List<Integer>> result = new ArrayList<>(set);
        return result;


       

    }


    public  static void calci(int [] nums, int target, int sum, int i, List<List<Integer>> a,  List<Integer> b )
    {
        if(i == nums.length)
        {
            if(sum == target)
            {
                a.add(new ArrayList<>(b));
            }

            return;
        }

        b.add(nums[i]);
        sum += nums[i];
        calci(nums,target, sum ,i+1,a,b);

        b.remove(b.size() -1);
        sum -= nums[i];
        calci(nums, target, sum,i+1,a,b);
    }
}




// leetcode approach
class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) 
    {
         int i =0;
        int sum=0;
        Arrays.sort(nums);
        List<Integer> b = new ArrayList<>();
        List<List<Integer>> a = new ArrayList<>();
        calci(nums,target,sum,i,a,b);

        HashSet<List<Integer>> set = new HashSet<>(a);

        // Convert the HashSet back to a List
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

     public  void calci(int [] nums, int target, int sum, int i, List<List<Integer>> a,  List<Integer> b )
    {
        if(i == nums.length)
        {
            if(sum == target)
            {
                a.add(new ArrayList<>(b));
            }

            return;
        }

        b.add(nums[i]);
        sum += nums[i];
        calci(nums,target, sum ,i+1,a,b);

        b.remove(b.size() -1);
        sum -= nums[i];
        calci(nums, target, sum,i+1,a,b);
    }
}
