import java.util.HashMap;

class Solution {
    // Helper method to check if a character is a vowel
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int solve2(String word, int k) {
        int i = 0, j = 0, n = word.length();
        int consonantCount = 0;
        int totalSubstrings = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();

        while (j < n) {
            // Increment consonant count or update vowel map
            if (!isVowel(word.charAt(j))) {
                consonantCount++;
            } else {
                vowelMap.put(word.charAt(j), vowelMap.getOrDefault(word.charAt(j), 0) + 1);
            }

            // Adjust the window if there are at least 5 distinct vowels and more than k consonants
            while (vowelMap.size() >= 5 && consonantCount > k) {
                if (isVowel(word.charAt(i))) {
                    vowelMap.put(word.charAt(i), vowelMap.get(word.charAt(i)) - 1);
                    if (vowelMap.get(word.charAt(i)) == 0) {
                        vowelMap.remove(word.charAt(i));
                    }
                } else {
                    consonantCount--;
                }
                i++;
            }

            // Count valid substrings in the current window
            totalSubstrings += (j - i + 1);
            j++;
        }

        return totalSubstrings;
    }

    public int countOfSubstrings(String word, int k) {
        return solve2(word, k) - solve2(word, k - 1);
    }
}
