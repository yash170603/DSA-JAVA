public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        Integer maj1 = null;
        int count1 = 0;

        Integer maj2 = null;
        int count2 = 0;
        
        for (int num : nums) {
            if (maj1 != null && num == maj1) {
                count1++;
            } else if (maj2 != null && num == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (maj1 != null && num == maj1) {
                count1++;
            } else if (maj2 != null && num == maj2) {
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if (count1 > Math.floor(n / 3)) {
            result.add(maj1);
        }
        if (count2 > Math.floor(n / 3)) {
            result.add(maj2);
        }
        
        return result;
    }
}

// The given Java code is an implementation of the Boyer-Moore Majority Vote algorithm to find elements that appear more than ⌊n / 3⌋ times in an array `nums`. Here's the intuition behind how it works:

// 1. **Initialization**:
//    - `maj1` and `maj2` represent the two potential majority elements.
//    - `count1` and `count2` represent the counts of `maj1` and `maj2` respectively.

// 2. **Finding Potential Majority Elements**:
//    - Iterate through the array `nums`.
//    - Check if the current element is equal to either `maj1` or `maj2`.
//    - If it matches `maj1` or `maj2`, increment the count of the corresponding element.
//    - If it doesn't match either, and the counts of `maj1` and `maj2` are both not 0, decrement both counts. This step simulates eliminating three distinct elements, one from each of the two potential majority elements and one different element.
//    - If the counts reach 0, update `maj1` or `maj2` with the current element.

// 3. **Counting Occurrences**:
//    - After finding the potential majority elements, count their occurrences again in the array to ensure they meet the criteria of appearing more than ⌊n / 3⌋ times.

// 4. **Generating Result**:
//    - If the count of `maj1` is greater than ⌊n / 3⌋, add `maj1` to the result list.
//    - If the count of `maj2` is greater than ⌊n / 3⌋, add `maj2` to the result list.

// 5. **Return Result**:
//    - Return the list containing the majority elements found.

// The algorithm efficiently finds the majority elements with linear time complexity. It's based on the fact that there can be at most two elements that appear more than ⌊n / 3⌋ times in an array. This algorithm extends the Boyer-Moore Voting Algorithm to handle finding more than one majority element.
