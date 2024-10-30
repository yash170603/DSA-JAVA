import java.util.Stack;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        // Fill the stack with indices of the increasing elements
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        int maxWidth = 0;
        
        // Traverse from right to left
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        
        return maxWidth;
    }
}
