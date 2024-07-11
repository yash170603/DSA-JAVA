import java.util.Stack;

class Solution {
    public String reverseParentheses(String pp) {
        int m= pp.length();
        Stack<StringBuilder> s = new Stack<>();
        StringBuilder temp = new StringBuilder(pp);
        temp.append(')');
        temp.insert(0,'(');
        String p = temp.toString();
        int n = p.length();
        
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '(') {
                s.push(new StringBuilder());
            } else if (p.charAt(i) == ')') {
                // Pop the top StringBuilder, reverse it, and append to the previous StringBuilder
                StringBuilder popped = s.pop();
                popped.reverse();
                if (!s.isEmpty()) {
                    s.peek().append(popped);
                } else {
                    s.push(popped);
                }
            } else {
                // Append character to the current StringBuilder at the top of the stack
                s.peek().append(p.charAt(i));
            }
        }
        
        // Reverse the final StringBuilder left in the stack
        StringBuilder result = s.pop(); 
        return result.reverse().toString();
    }
}
