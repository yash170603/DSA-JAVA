// class Solution {    // passed 976/980 cases 99.59 percent
//     public long largestPerimeter(int[] nums)
//      {
//         Arrays.sort(nums);
//          int m = nums.length;
//         long [] prefix = new long[m];
//         prefix[0]= nums[0];
//         for( int i=1;i<m;i++)
//         {
//             prefix[i]=prefix[i-1]+nums[i];
//         }
//         long ans =0;

//         for( int n=3;n<=m;n++)
//         {
//             for( int i=0;i<=m-n;i++)
//             {
//                 if( i ==0)
//                 {
//                      if( prefix[i+n-2]>nums[i+n-1])
//                      {
//                         ans = Math.max(ans,prefix[i+n-1]);
//                      }
//                 }
//                 else
//                 {
//                    if( prefix[i+n-2]-prefix[i-1]>nums[i+n-1])
//                    {
//                        ans = Math.max( ans,prefix[i+n-1]-prefix[i-1]);
//                    }
//                 }
               
//             }
//         }
           
//            if( ans == 0)
//            return -1;
//         return ans;
//     }
// }
public class Solution {  // here they are increasing thngs lineraly like 3 ka polygon, 4 ka polygon , 5 ka plygon,, mine was exploring all combinations possible of each length
    public long largestPerimeter(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        long perimeter = 0;
        long cumSum = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < cumSum) {
                perimeter = nums[i] + cumSum;
            }
            cumSum += nums[i];
        }

        return perimeter == 0 ? -1 : perimeter;
    }
}
