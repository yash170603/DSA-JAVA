class Solution {
    public List<String> wordSubsets(String[] w1, String[] w2) {
        int n = w1.length;
        int m = w2.length;
 
        int[] maxFreq = new int[26];
        for (String word : w2) {
            int[] freq = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : w1) {
            int[] freq = countFrequency(word);
            if (isSubset(maxFreq, freq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Count frequency of each character in a string
    private int[] countFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Check if the global maxFreq is a subset of the current freq
    private boolean isSubset(int[] maxFreq, int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
