class Solution {
    public int minBitFlips(int start, int goal) {
        
        int num= start^goal;
         int count = 0;
        while (num > 0) {
            // Increment count if the last bit is set (i.e., if num is odd)
            count += num & 1;
            // Right shift num by 1 bit
            num >>= 1;
        }
        return count; // Integer.bitCount(num);

    }
}
