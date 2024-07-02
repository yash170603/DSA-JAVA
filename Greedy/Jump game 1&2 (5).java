// jp-1
  class Solution {
    public boolean canJump(int[] nums) {
          int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) { // mujh tak koi starting se nahi phunch paya toh aage kaise jaenge, sarting se chain ki need hai
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
//recursive
class Solution {
   int n;
    public boolean canJump(int[] nums) {
        n = nums.length-1;
        return solve(0,nums);
    }

    public boolean solve( int index, int  [] nums)
    {
        if(index >= n)
        return true;


        int range  = nums[index];
        for( int i = 1; i<=range;i++ )
        {
            if( solve(index+i,nums))
            return true;
        }

        return false;


    }
}
