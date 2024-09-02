class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total sum of chalk required in one full cycle
        long totalChalk = 0;
        for (int num : chalk) {
            totalChalk += num;
        }
        
        // Step 2: Reduce k by the total sum of chalk
        k %= totalChalk;
        
        // Step 3: Find the student who will use the last piece of chalk
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        return -1; // This line will never be reached
    }
}
