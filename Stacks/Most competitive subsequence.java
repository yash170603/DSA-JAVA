import java.util.Stack;

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        
        // Iterate through each element in the nums array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is smaller than the top of the stack
            // and we can still form a subsequence of size k
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + (n - i) > k) {
                stack.pop();
            }
            // Push the current element to the stack if we haven't yet formed the subsequence of size k
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        
        // Convert stack to array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
