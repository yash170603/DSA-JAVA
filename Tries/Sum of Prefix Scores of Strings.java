class Solution {
    public Trie root;

    public int[] sumPrefixScores(String[] words) {
        root = new Trie();

        // Insert all words into the Trie
        for (String s : words) {
            insert(s);
        }

        // Calculate prefix scores for each word
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = find(words[i]);
        }

        return ans;
    }

    // Insert a word into the Trie and update prefix counts
    public void insert(String x) {
        Trie instance = root;
        for (int i = 0; i < x.length(); i++) {
            int val = x.charAt(i) - 'a';
            if (instance.kid[val] == null) {
                instance.kid[val] = new Trie();
            }
            instance = instance.kid[val];
            instance.count++;  // Increment count every time a node is visited
        }
    }

    // Calculate prefix score for a word
    public int find(String x) {
        Trie instance = root;
        int sum = 0;
        for (int i = 0; i < x.length(); i++) {
            instance = instance.kid[x.charAt(i) - 'a'];
            sum += instance.count;  // Add the count for each character in the prefix
        }
        return sum;
    }
}

class Trie {
    Trie[] kid;
    int count;

    Trie() {
        kid = new Trie[26];
        count = 0;  // Tracks how many times a prefix is shared
    }
}
