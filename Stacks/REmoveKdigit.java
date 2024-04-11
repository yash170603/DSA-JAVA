// class Solution {
//     public String removeKdigits(String num, int k) {
//         Stack<Character> st = new Stack<>();
//         for(Character ch : num.toCharArray()) {
//             while(!st.isEmpty() && k > 0 && ch < st.peek()) {
//                 st.pop();
//                 k--;
//             }

//             if(!st.isEmpty() || ch != '0') {
//                 st.push(ch);
//             }
//         }

//         // This is a special edge case --> 1 2 3 4
//         while(!st.isEmpty() && k-- > 0) {
//             st.pop();
//         }
//         if(st.isEmpty()) return "0";
        

//         // Store the ans -->
//         String ans = "";
//         while(!st.isEmpty()) {
//             ans = st.peek() + ans;
//             st.pop();
//         }
//         return ans;
//     }
// }
class Solution {
    public String removeKdigits(String num, int k) 
    {
        if(k == num.length())
            return "0";
        
        Stack<Character> stack = new Stack<>();
        
        int i=0;
        
        while(i < num.length())
        {
            char ch = num.charAt(i);
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(!stack.isEmpty() && stack.peek() > ch && k > 0)
            {
                stack.pop();
                k--;
            }
            stack.push(ch);
            i++;
        }
        //for corne case like 1111
        while(k > 0)
        {
            stack.pop();
            k--;
         }
        
        //constructing number from stack
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        sb.reverse();
        
        while(sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}



class Solution {
    public String removeKdigits(String num, int k) {
        
        StringBuilder ans = new StringBuilder();

        int n = num.length();

        ans.append(num.charAt(0));
        int count = 0;

        for (int i = 1; i < n; i++) {
            char curr = num.charAt(i);
            while (count < k && ans.length() > 0 && ans.charAt(ans.length() - 1) > curr) {
                ans.deleteCharAt(ans.length() - 1);
                count++;
            }
            ans.append(curr);
        }

        // Handle the case where there are still remaining digits to be removed
        while (count < k && ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
            count++;
        }

        // Remove leading zeros
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        // If all digits were removed, return "0"
        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();
    }
}

