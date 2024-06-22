class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;
        int i = 0, j = 0;

        long result = 0;
        int countMax = 0;

        while (j < n) {
            if (nums[j] == maxE) {
                countMax++;
            }

            while (countMax >= k) {
                result += n - j;    //its the leat subarrray wndow ehere it appears least k times, will come more for subarrays including this one

                if (nums[i] == maxE) {
                    countMax--;
                }
                i++;
            }
            j++;
        }

        return result;
    }
}


//Approach-2 (Without Sliding Window)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;

        long result = 0;

        List<Integer> maxIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == maxE) {
                maxIndices.add(i);
            }

            int size = maxIndices.size();
            if (size >= k) {
                int last_i = maxIndices.get(size - k);
                result += last_i + 1;
            }
        }

        return result;
    }
}
