import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int mSum = 0;
        
        // Calculate the sum of the given rolls
        for (int i : rolls) {
            mSum += i;
        }

        // Calculate the required sum for the missing rolls
        int req = (mean * (m + n)) - mSum;

        // If the required sum is less than n or greater than 6*n, it's impossible to achieve
        if (req < n || req > 6 * n) {
            return new int[0];
        }

        // Initialize the result array
        int[] res = new int[n];
        
        // Calculate the base value for each roll
        int baseValue = req / n;
        int remainder = req % n;

        // Fill the result array with the base value
        Arrays.fill(res, baseValue);

        // Distribute the remaining sum across the array
        for (int i = 0; i < remainder; i++) {
            res[i]++;
        }

        return res;
    }
 
}
