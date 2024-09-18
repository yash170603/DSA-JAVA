import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        List<Integer> tail = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(tail, num);

            // If num is not found, binarySearch returns (-insertion_point - 1).
            // To get the insertion point, we take -(idx + 1).
            if (idx < 0) {
                idx = -(idx + 1);
            }

            // If the index is equal to the size of the list, append it.
            if (idx == tail.size()) {
                tail.add(num);
            } else {
                // Otherwise, replace the existing value with num.
                tail.set(idx, num);
            }
        }

        return tail.size(); // The size of tail is the length of the LIS.
    }
}
