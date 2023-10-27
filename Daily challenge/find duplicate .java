import java.util.*;
import java.util.ArrayList;
class Solution {
    public int findDuplicate(int[] nums) 
    {
        // if(nums.length>( Math.pow(10,5)+1))
        // return 0;
        // int xx=0;
        // ArrayList<Integer> x = new ArrayList<Integer>();
        // HashSet<Integer> h = new HashSet<Integer>();

        // // for(int i=0;i<nums.length;i++)
        // // {
        // //     for(int j=i+1;j<nums.length;j++)
        // //     {
        // //         int v = nums[i];
        // //         int y= nums[j];
        // //         if((v^y) == 0)
        // //         {
        // //           xx= nums[j];
        // //        break;
        // //         }
               
        //        //123245
        // //     }
        // // }
        // for(int y:nums)
        // {
        //     x.add(y);
        // }
        // Collections.sort(x);
        
        // for(int i=0;i<x.size()-1;i++)
        // {
        //     if(x.get(i) == x.get(i+1))
        //     {
        //         xx= x.get(i);
        //     }
        // }
        // return xx;

        //  int len = nums.length;
        // for (int i = 0; i < len; i++) {
        //     for (int j = i + 1; j < len; j++) {
        //         if (nums[i] == nums[j]) {
        //             return nums[i];
        //         }
        //     }
        // }

        // return len;
          int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }
}

// optimum

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find the intersection point of the two pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate element)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
