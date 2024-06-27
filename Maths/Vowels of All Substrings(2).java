class Solution {
    public long countVowels(String word) {

         long totalSum = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i))) {
                totalSum += (long) (i + 1) * (n - i);
            }
        }
        return totalSum;
    }
    public  boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
