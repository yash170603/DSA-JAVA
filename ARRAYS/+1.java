import java.util.Arrays;

public class Solution {
    public static int[] plusOne(int[] digits) {
        // Start from the rightmost digit
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;
            // If there is no carry, return the result
            if (digits[i] < 10) {
                return digits;
            }
            // Otherwise, there is a carry
            digits[i] = 0;
        }

        // If we are here, it means there was a carry all the way through
        // We need to add a new leading digit 1
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

   
}
