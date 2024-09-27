class Solution {
   public long validSubstringCount(String w1, String w2) {
       // Create a frequency map for characters in w2
       Map<Character, Integer> cnt = new HashMap<>();
       // Initialize the frequency map and the total number of characters to match
       int match = 0; // Total number of characters (including duplicates) to match
       long res = 0;  

       // Populate the frequency map for word2
       for (char ch : w2.toCharArray()) {
           cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
           match += 1;  // Every character occurrence increases the match count
       }

       // Sliding window technique over w1
       int j = 0;  // Left pointer of the window
       for (int i = 0; i < w1.length(); ++i) {
           // Decrease the count of the current character in the window
           if (cnt.containsKey(w1.charAt(i))) {
               cnt.put(w1.charAt(i), cnt.get(w1.charAt(i)) - 1);
               if (cnt.get(w1.charAt(i)) >= 0) {
                   match--;  // We've matched one occurrence of this character
               }
           }

           // When all characters are matched
           while (match == 0) {
               // Add all valid substrings from this point
               res += w1.length() - i;

               // Move the left side of the window (increment j)
               if (cnt.containsKey(w1.charAt(j))) {
                   cnt.put(w1.charAt(j), cnt.get(w1.charAt(j)) + 1);
                   if (cnt.get(w1.charAt(j)) > 0) {
                       match++;  // We've lost a match
                   }
               }
               j++;  // Move left pointer of the window
           }
       }
       return res;
   }
}
