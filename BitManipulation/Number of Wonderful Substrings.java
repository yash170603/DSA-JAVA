// we use a hashmap , with initial entry as 0000 -1 
// then, we keep xorring each character 
//    int shift = ch - 'a';

// if ch = 1, then shift = 0(67-67)
//     then currvalof character = 1<<shift= 0001 

//     these are the xor values-
//     a       c       c       b        b         d
//     001    101     001    011      001      1001

//     after each xor we check for strings with all even occurrance, and strings with only 1 odd occurance
    
//     even occurance check;-
//     at 2nd index C, we get 001,
//     we check if map has 001?
//     if yes that means adding the current element to xor(chain/product) made  the value of that region as 0 i.e having every pair as evens, cc ,dd etc,
//     i.e  1 ,1, -1 = on adding -1 in result, we get  value as 1, but we had prev occurnce of sum 1 at index 0,
//     i.e sum from index 2(-1) to the index 1(1) is meaning less

//     so when 001 at c comes, we check if it has occured before, we got yes as a got 001 previously, and from index 0 to 2 i.e from a to c we see c oocurs two times,
//     making it equal to occurance of the 001, as c^c ==0


//     now for the parts where an odd digit count was included, 
    
//     taking smae exmaple
//     a       c       c       b        b         d
//     001    101     001    011      001      1001

//     lets take a portion as ccbbd
//     if all the characters we coming as even in this  portiuon taht means no digit was single, but this isnt the case
//     to figure out the odd one out, we xorr the last xorr or cumulative xor with all a,b,c,d 
//     cumxor^a=!0
//     cumxor^b=!0
//     cumxor^c=!0
//     cumxor^d= ==0 , which means d was the repeated one,

//     now considering the above, we take sample as c b b;

//   c     b     b
// 001    011   001
//     cbb^a = 000
//     cbb^b = 011

//     wo odd dhoondh re jisko add krene pr seq. xorr =0 ho jara hai, like ki isse pehle k jo xorr value thi agar vo present hai toh current seq ==0;
//     cbba !=0
//     cbbb !=0
//     cbb^c == this makes the xor zero. , not neccessary ki xorred val 0 hi aae, lekin agar xorred value already present hai map mei
//         iska matlb hua ki is char ko add kren pr xorr 0 ho jara, i.e it was odd, occurance
//         and count the value of the xorred result in map. thats the ans of good string with 1 odd occ.

class Solution {
    public long wonderfulSubstrings(String word) {
        
        Map<Long, Long> mp = new HashMap<>();

        mp.put(0L, 1L);
        int cum_xor = 0;

        long result = 0;

        for (char ch : word.toCharArray()) {
            int shift = ch - 'a';

            cum_xor ^= (1 << shift);

            result += mp.getOrDefault((long) cum_xor, 0L);

            for (char ch1 = 'a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';

                long check_xor = (cum_xor ^ (1 << shift));

                result += mp.getOrDefault(check_xor, 0L);
            }

            mp.put((long) cum_xor, mp.getOrDefault((long) cum_xor, 0L) + 1);
        }

        return result;
    }
}
