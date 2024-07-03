class Solution {
    public int minDifference(int[] nums) {
        
         int n= nums.length;
         if ( n<=4)
         return 0;
        Arrays.sort(nums);
       
          int option1 = nums[n - 1] - nums[3];
        int option2 = nums[n - 2] - nums[2]; //iske bina 44/61 hogye the
        int option3 = nums[n - 3] - nums[1];//iske bina 44/61 hogye the
        int option4 = nums[n - 4] - nums[0];

        // Return the minimum difference out of all options
        return Math.min(Math.min(option1, option2), Math.min(option3, option4));
        
    }
}
