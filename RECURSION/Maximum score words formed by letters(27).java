//brute force
class Solution {
    HashMap<Character,Integer> map ;
    int [] cfreq;
    int ans;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
 int index = 0;
        map = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            map.put((char) i, score[index]);
            index++;
        }

        cfreq = new int[256]; 
        for (char c : letters) {
            cfreq[c]++;
        }

        ans = 0;
        List<String> x = new ArrayList<>();
        dfs(0, x, words);
        return ans;
    }

   
    public void dfs(int index, List<String> x, String[] words) {
        if (index == words.length) {
            ans = Math.max(ans, check(x));
            return;
        }

        x.add(words[index]);
        dfs(index + 1, x, words);
        x.remove(x.size() - 1);
        dfs(index + 1, x, words);
    }

     public int check(List<String> x) {
        int val = 0;
        int[] ab = cfreq.clone();
        for (String d : x) {
            char[] ch = d.toCharArray();
            for (char e : ch) {
                if (ab[e] == 0) {
                    return 0;
                }
                val += map.get(e);
                ab[e]--;
            }
        }
        return val;
    }
}



// optimised


class Solution {
    int n;
    int maxScore;

    void solve(int i, int[] score, String[] words, int currScore, int[] freq) {
        maxScore = Math.max(maxScore, currScore);

        if (i >= n)
            return;

        int[] tempFreq = Arrays.copyOf(freq, freq.length);

        int j = 0;
        int tempScore = 0;

        while (j < words[i].length()) {
            char ch = words[i].charAt(j);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            j++;
        }

        // Take words[i]
        if (j == words[i].length()) { // It means we could form the word words[i]
            solve(i + 1, score, words, currScore + tempScore, tempFreq);
        }

        // Not Take words[i]
        solve(i + 1, score, words, currScore, freq);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];

        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        maxScore = Integer.MIN_VALUE;
        n = words.length;

        solve(0, score, words, 0, freq);

        return maxScore;
    }
}
