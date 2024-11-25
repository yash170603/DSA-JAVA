class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
/*The expression `freq2[ch - 'a']++` is a common idiom in programming, especially when dealing with characters. Let me break it down for you:

- `ch` is a variable representing a character.
- `'a'` is the ASCII value of the lowercase letter 'a'.
- `ch - 'a'` calculates the offset of the character `ch` from 'a'. For example, if `ch` is 'c', then `ch - 'a'` would be 2 because 'c' is the 2nd letter after 'a'.
- `freq2[ch - 'a']++` increments the count of the character `ch` in the `freq2` array.
In simpler terms, this line of code is updating the frequency count of each character in the `freq2` array.
It's using the fact that characters in programming languages are represented as ASCII values, and by subtracting the ASCII value of 'a',
you get a zero-based index corresponding to the position of the character in the English alphabet. This is often used when dealing with arrays or data structures that store counts of characters.

Let's dry run the `closeStrings` method with an example to understand how it works:

```java
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("abc", "bca")); // Expected output: true
    }
}
```

Now, let's go through the code step by step:

1. Initialize frequency arrays `freq1` and `freq2` for each letter of the alphabet.
2. Count the frequency of each character in `word1` and `word2` and update the corresponding frequency arrays.
3. Check if there are any characters in one word that are not present in the other. If so, return false. This is done in the first loop.

    In this example, both "abc" and "bca" have the same set of characters, so this condition is satisfied.

4. Sort the frequency arrays `freq1` and `freq2`.

    After sorting, `freq1` becomes [0, 1, 1, 1, 0, 0, ..., 0] (where the values represent the frequency of each letter).
    
    `freq2` becomes [0, 1, 1, 1, 0, 0, ..., 0].

5. Compare the sorted frequency arrays. If they are not equal, return false.

    In this case, both arrays are equal, so the method returns true.

The expected output for the provided example is `true` since "abc" and "bca" are considered close strings based on the conditions in the code.
This involves iterating over each character in both words once. Therefore, the time complexity for this part is O(max(N, M)), where N and M are the lengths of word1 and word2 respectively.*/
