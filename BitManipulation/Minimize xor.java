class Solution {
    public int minimizeXor(int n1, int n2) {
           int setBitsCount = Integer.bitCount(n2);  
        int ans = 0;  
     
        for (int i = 31; i >=0  && setBitsCount > 0; i--) {
            if ((n1 & (1 << i)) !=0 ) {    // see comments why    ((n1 & (1 << i)) ==1 is wrong ) 
                ans |= (1 << i);  
                setBitsCount--; 
            }
        }

        // 
       
        for (int i = 0; i < 32 && setBitsCount > 0; i++) { 
            if ((ans & (1 << i)) !=1 ) {   //---> 
                ans |= (1 << i);  
                setBitsCount--; 
            }
        }
        // crazy stuff Here, the condition (n1 & (1 << i)) == 1 checks if the result of the bitwise AND is exactly 1. However, this condition will only be true for the least significant bit (LSB) being 1 because the result of (1 << i) will always be a power of 2 (e.g., 1, 2, 4, 8, etc.), and the bitwise AND of any power of 2 with 1 can only be 1 if the LSB is set.

        
        return ans;
    }
}
// class Solution {
//     public int minimizeXor(int num1, int num2) {
//         int result = 0;
//         int targetSetBits = Integer.bitCount(num2); // Count the number of set bits in num2

//         // First pass: Match bits in num1 from most significant to least significant
//         for (int i = 31; i >= 0 && targetSetBits > 0; i--) {
//             if ((num1 & (1 << i)) != 0) { // If bit i in num1 is set
//                 result |= (1 << i); // Set bit i in result
//                 targetSetBits--;
//             }
//         }

//         // Second pass: Fill remaining set bits in the lowest unset positions
//         for (int i = 0; i < 32 && targetSetBits > 0; i++) {
//             if ((result & (1 << i)) == 0) { // If bit i in result is not set
//                 result |= (1 << i); // Set bit i in result
//                 targetSetBits--;
//             }
//         }

//         return result;
//     }
// }
