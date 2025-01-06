class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] netShifts = new int[n + 1]; // Use to store cumulative shifts

        // Calculate net shifts
        for (int[] range : shifts) {
            int i = range[0], j = range[1], dir = range[2];
            if (dir == 1) {
                netShifts[i] += 1; // Increment starting at i
                netShifts[j + 1] -= 1; // Decrement after j
            } else {
                netShifts[i] -= 1; // Decrement starting at i
                netShifts[j + 1] += 1;  
            }
        }

        // Apply cumulative shifts
        int shift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            shift += netShifts[i]; // Current shift value
            int newChar = ((result[i] - 'a') + shift) % 26; // Shift within bounds
            if (newChar < 0) newChar += 26; // Handle negative shifts
            result[i] = (char) ('a' + newChar); // Update character
        }

        return new String(result);
    }
}
