class Solution {
    public int[] vowelStrings(String[] words, int[][] q) {
        int n = words.length;
        int[] same = new int[n];
        int[] prefix = new int[n];
        int ans[] = new int[q.length];

        prefix[0] = (isV(words[0].charAt(0)) == true && isV(words[0].charAt(words[0].length() - 1)) == true) ? 1 : 0;
        same[0] = prefix[0];

        int prev = same[0];
        for (int i = 1; i < n; i++) {
            String s = words[i];
            if (isV(s.charAt(0)) && isV(s.charAt(s.length() - 1))) {
                prefix[i] = prev + 1;
                prev++;
                same[i] = 1;
            } else {
                prefix[i] = prev;
                same[i] = 0;
            }
        }

        int index = 0;
        for (int[] a : q) {

            int left = a[0];
            int right = a[1];
            int res = 0;
            if (left == right) {
                res = same[left];
                ans[index] = res;
            } else {
                if (left == 0) {
                    res = prefix[right];
                } else {
                    res = prefix[right] - prefix[left-1];
                }
                ans[index] = res;
            }

            index++;
        }
        return ans;

    }

    public boolean isV(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
