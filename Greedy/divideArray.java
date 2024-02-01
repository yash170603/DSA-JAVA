import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int m = nums.length;
        int n = 3;
        ArrayList<int[]> x = new ArrayList<>();

        for (int i = 0; i <= m - n; i += 3) {
            if (nums[i + n - 1] - nums[i] > k) {
                return new int[0][0];
            }
            if (i + 2 < m && nums[i + n - 1] - nums[i] <= k) {
                int[] temp = new int[3];
                temp[0] = nums[i];
                temp[1] = nums[i + 1];
                temp[2] = nums[i + 2];
                x.add(temp);
            }
        }

        // return x.toArray(new int[0][0]);
        int[][] ans = x.toArray(new int[x.size()][3]);
        return ans;

    }
}
// class Solution {
//     public int[][] divideArray(int[] nums, int k) {
//         int n = nums.length;

//         Arrays.sort(nums);

//         int[][] result = new int[n / 3][3];
//         int index = 0;

//         for (int i = 0; i <= n - 3; i += 3) {
//             if (nums[i + 2] - nums[i] > k) {
//                 return new int[0][0];
//             }

//             result[index] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
//             index++;
//         }

//         return result;
//     }
// }
