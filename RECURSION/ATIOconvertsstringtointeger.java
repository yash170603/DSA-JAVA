// non recursive 

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        boolean negative = false;
        int i = 0;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            negative = (s.charAt(i) == '-');
            i++;
        }
        
        long result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            if (result > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            i++;
        }
        
        return negative ? (int) -result : (int) result;
    }
}
/*Clamping, in the context of the given code, refers to restricting the value of the result variable to a specific range when it goes beyond the valid range for a 32-bit signed integer (int).
In Java, the valid range for an int is from -2,147,483,648 to 2,147,483,647.
  If result becomes greater than Integer.MAX_VALUE, we return Integer.MAX_VALUE if the number is positive,
  and Integer.MIN_VALUE if the number is negative. This ensures that the final result stays within the valid range of a 32-bit signed integer.*/



// recursive approach 

 class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0; // Base case: if the input string is empty, return 0.
        }

        boolean negative = false;
        int index = 0;

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            negative = (s.charAt(0) == '-');
            index++;
        }

        return recursiveAtoi(s, negative, index, 0);
    }

    private int recursiveAtoi(String s, boolean negative, int index, int result) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return negative ? -result : result;
        }

        int currentDigit = s.charAt(index) - '0';

        // Check for overflow before adding the next digit.
        if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < currentDigit)) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return recursiveAtoi(s, negative, index + 1, result * 10 + currentDigit);
    }
}











