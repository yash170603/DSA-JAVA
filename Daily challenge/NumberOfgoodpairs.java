import java.util.HashMap;
class Solution {
    public int numIdenticalPairs(int[] nums)
     {
       // HashMap<Integer,Integer> x = new HashMap<Integer,Integer>();
       int count =0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i] == nums[j])
                {
                   count++;
                }
            }
        }

        return count;
    }
}
