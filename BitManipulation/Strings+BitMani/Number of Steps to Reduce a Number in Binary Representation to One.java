class Solution {
    public int numSteps(String s) {
        int count = 0;       // To count the number of steps
        int carry = 0;       // To handle carries during addition

        // Start from the least significant bit (rightmost bit) and process towards the left
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                // Current bit (with carry) is 1 → Add 1 → Generates a carry
                carry = 1;
                count += 2;  // Adding 1 (making it even) and dividing by 2
            } else {
                // Current bit (with carry) is 0 → Simply divide by 2
                count++;
            }
        }

        // Handle the final carry if it exists
        return count + carry;
    }
}
