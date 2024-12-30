
// for every index in the target i had all choices, see examples, i.e its not neccessary to go only ---> once u choose a character,, u can go back and forth.
// this was a catch, could have made it more complicated by applying a for loop again and again tracking indexes, ---> bad code, 
// since u cant go back the from the prev selected index,  we think like this, i need character a at target index i, for any word in the word [],
//  if the position in freq[][] has items, x , we make x* next items call
//i.e
// t=aba
//  t = 0  wordIndex=0, for eg ->1   0,1,2,3
//                             a->   1 1 0 1
//                             b->   1 1 1 1
//                             c->   1 1 2 1  

// at index 0, we need a, for 0 index a has  only 1freq, so we call it only once, if i had been 2 we would haev done it twice , then its like lcs, 
// and the previous index forbidden is self handled,because hum aage hi badh re,
// however, ek doubt ye hai tab kya jab khin pr koi char needed hai target ko aur freq 0 hai us jagah pr, 



class Solution {
    private int m;
    private int k;
    private final int MOD = (int) 1e9 + 7;
    private int[][] memo;

    private int solve(int i, int j, long[][] freq, String target) {
        if (i == m) {
            return 1;
        }

        if (j == k) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int notTaken = solve(i, j + 1, freq, target) % MOD;

        int taken = (int) ((freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, target)) % MOD);

        return memo[i][j] = (notTaken + taken) % MOD;
    }

    public int numWays(String[] words, String target) {
        k = words[0].length();
        m = target.length();

        long[][] freq = new long[26][k];

        // Populate frequency array
        for (String word : words) {
            for (int col = 0; col < k; col++) {
                freq[word.charAt(col) - 'a'][col]++;
            }
        }

        memo = new int[m][k];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, freq, target);
    }
}

