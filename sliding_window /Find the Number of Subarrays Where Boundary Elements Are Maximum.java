class Solution {
    public long numberOfSubarrays(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for (int n : nums) {
            while (!stack.isEmpty() && stack.peek() < n) {
                ans += consumeStack(stack);
            }
            stack.push(n);
        }

        while (!stack.isEmpty()) {
            ans += consumeStack(stack);
        }
        return ans;
    }

    public long consumeStack(Stack<Integer> stack) {
        int top = stack.pop();
        long subCounts = 1;
        long result = 1;
        while (!stack.isEmpty() && stack.peek() == top) {
            stack.pop();
            result += (++subCounts);
        }
        return result;
    }
}
