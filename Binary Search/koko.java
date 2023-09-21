import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length - 1]; // Initialize 'high' to the maximum pile size
        
        while (low < high) {
            int ans = low + (high - low) / 2;
            int hoursRequired = 0;
            
            for (int pile : piles) {
                hoursRequired += (pile + ans - 1) / ans; // Ceiling division
            }
            
            if (hoursRequired <= h) {
                high = ans;
            } else {
                low = ans + 1;
            }
        }
        
        return low;
    }
}
