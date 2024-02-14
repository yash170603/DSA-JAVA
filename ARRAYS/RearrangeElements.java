class Solution {   // with less extra space
    public int[] rearrangeArray(int[] nums) {
          int n = nums.length;
        int pi = 0; // positive index
        int ni = 1; // negative index

        int[] result = new int[n];

        for (int num : nums) {
            if (num > 0) {
                result[pi] = num;
                pi += 2;
            } else {
                result[ni] = num;
                ni += 2;
            }
        }

        return result;
    }
}

// 2ndapproach
/*get 2 arrays of half a length of main array, each for all positive and negative elements, add them alternatively in new array*/
