import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        
        // Convert each integer to a string and add it to the list
        for (int x : nums) {
            String s = String.valueOf(x); // Corrected this line
            list.add(s);
        }
        
        // Custom comparator to sort the strings
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1.length();
                int len2 = s2.length();
                int minLen = Math.min(len1, len2);

                // Compare digits at each index up to the length of the shorter string
                for (int i = 0; i < minLen; i++) {
                    int digit1 = s1.charAt(i) - '0';
                    int digit2 = s2.charAt(i) - '0';

                    if (digit1 != digit2) {
                        // If digits are different, return the greater one
                        return digit2 - digit1; // Higher digit comes first
                    }
                }

                // If digits are the same up to the min length, compare concatenated strings
                return (s2 + s1).compareTo(s1 + s2); // Ensure correct sorting order for combinations
            }
        });

        StringBuilder ans = new StringBuilder();

        // Append all sorted numbers
        for (String temp : list) {
   
            ans.append(temp);
        }
      
        // Edge case: if the largest number is "0", we want to return "0" instead of "000..."  zero se sbada kya hi hoga, jab already decending mei kre rahe,a ur starting zero hai toh toh mtlb saare hi zero hoenge na aage, chutiye
        if (ans.charAt(0) == '0') {
            return "0";
        }

        return ans.toString();
    }
}
