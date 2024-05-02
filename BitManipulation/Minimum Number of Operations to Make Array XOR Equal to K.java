// 	1- 001
// 	2- 010
// 	3- 011
// 	4- 100

// Now total xor is 
 
// 4 =100,,  


// Required xor product was = bit val of k, i.e is 1 =  001,

// Therefore task wa sto compute  diff in number of bits 

// Or checkking each bit of K  with xorr of all values of nums for the partucluar bit
// As in xor of 1 st bit of all nums compared with  1st bit of k,
// If same no operation required, if not bit should be changed,



// **FOR A XOR BIT OF  (2^3^4^1) TO BE 0, OS AND 1S SHOULD BE IN EVEN PAIRS OF THAT PARTICULAR BIT
// , AS 00-11, ELSE IT WILL BE 1
// FOR EG 0001 = 1  AND 0011 =0;( XOR OF 1ST BIT SERIES 1^0^1^0 =0, FOR 2,3,1,4).
// STEPS.
//  FIND XOR OF A PARTICULAR(n) BIT OF ALL NUMBERS
// COMPARE WITH THE PARTICULAR(n) BIT, IF SAME, SKIP ELSE ANS++;



class Solution {
    public int minOperations(int[] nums, int k) {
        
        int totxor =0;
        for( int x: nums)
        {
            totxor = totxor^x;
        }    
  
    int g = totxor ^k;

    return Integer.bitCount(g);


    }
}
// class Solution {
//     public int minOperations(int[] nums, int k) {
        
//         int ans=0;

//         for( int bit =0;bit<=20;bit++)
//         {
//             int xorr=0;
//             for(int x : nums)
//             {
//                 int bitval = (1<<bit)&x;
//                 xorr = xorr^ bitval;
//             }
//             int kbitval = (1<<bit)&k;
//             if( xorr != kbitval)
//             {
//                 ans++;
//             }
//         }

//         return ans;
//     }
// }

