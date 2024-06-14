import java.util.HashSet;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        int moves = 0;

        for (int num : nums) {
            while (!uniqueNumbers.add(num)) {
                num++;
                moves++;
            }
        }

        return moves;
    }
}



//passed 55/63
class Solution {
    public int minIncrementForUnique(int[] nums) {
        HashSet<Integer> x = new HashSet<>();
        
        int ans=0;

        for( int i=0;i<nums.length;i++)
        {
           

            if( ! x.contains(nums[i]))
            {
                x.add(nums[i]);
            }

            else
            {

                while( x.contains(nums[i]))
                {
                    nums[i]++;
                    ans++;
                }

                x.add(nums[i]);
            }
        }

        return ans;
    }
}
