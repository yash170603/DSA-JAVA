//bf
class Solution {
    public void moveZeroes(int[] nums)
     {
        func(nums);
        return;

    }

    public void func(int [] nums)
    {
       ArrayList<Integer> x = new ArrayList<>();

        for(int i =0;i<nums.length;i++)
        {
            if(nums[i] !=0)
            {
                x.add(nums[i]);
            }
        }

        for(int j=0;j<nums.length;j++)
        {
            nums[j] =0;
        }

        for(int k =0;k<x.size();k++)
        {
            nums[k] = x.get(k);
        }
    }

}


/// optimal

class Solution {
    public void moveZeroes(int[] nums) 
   {
        int i = 0;
        for (int num : nums)
        {
            if (num != 0)
            {
                nums[i] = num;
                i++;
            }
        }

        while (i <= nums.length - 1)
        {
            nums[i] = 0;
            i++;
        }

    }
}
