class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y)
            return solve1(s, x, y);
        return solve(s, x, y);
    }

    public int solve1(String s, int x, int y) { // x > y, we need "ab" as a pair
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() == 'a' && s.charAt(i) == 'b') {
                st.pop();
                sum += x;
            } else {
                st.push(s.charAt(i));
            }
        }

        // Emptying stack to handle remaining pairs
        Stack<Character> tempStack = new Stack<>();
        while (!st.isEmpty()) {
            char top = st.pop();
            if (!tempStack.isEmpty() && tempStack.peek() == 'a' && top == 'b') {
                tempStack.pop();
                sum += y;
            } else {
                tempStack.push(top);
            }
        }

        return sum;
    }

    public int solve(String s, int x, int y) { // y > x, we need "ba" as a pair
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() == 'b' && s.charAt(i) == 'a') {
                st.pop();
                sum += y;
            } else {
                st.push(s.charAt(i));
            }
        }

        // Emptying stack to handle remaining pairs
        Stack<Character> tempStack = new Stack<>();
        while (!st.isEmpty()) {
            char top = st.pop();
            if (!tempStack.isEmpty() && tempStack.peek() == 'b' && top == 'a') {
                tempStack.pop();
                sum += x;
            } else {
                tempStack.push(top);
            }
        }

        return sum;
    }
}
