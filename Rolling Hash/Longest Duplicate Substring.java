import java.util.*;

 class Solution {
    private static final int P = 10000007;
    private int[] roll;
    
    private boolean match(String s, int len, int size, StringBuilder ans) {
        Map<Integer, List<Integer>> m = new HashMap<>(); // Key->hashValue...Value->starting index of substring
        int hash = 0; // curr window hash
        for (int i = 0; i < size; ++i) {
            hash = (hash * 26 + (s.charAt(i) - 'a')) % P;
        }
        
        m.putIfAbsent(hash, new ArrayList<>());
        m.get(hash).add(0);
        
        // Rolling hash (sliding window)
        for (int j = size; j < len; ++j) {
            hash = ((hash - roll[size - 1] * (s.charAt(j - size) - 'a')) % P + P) % P;
            hash = (hash * 26 + (s.charAt(j) - 'a')) % P;
            if (m.containsKey(hash)) {
                for (int start : m.get(hash)) {
                    String temp = s.substring(start, start + size);
                    String curr = s.substring(j - size + 1, j + 1);
                    if (temp.equals(curr)) {
                        ans.setLength(0); // Clear the StringBuilder
                        ans.append(temp);
                        return true;
                    }
                }
            }
            m.putIfAbsent(hash, new ArrayList<>());
            m.get(hash).add(j - size + 1);
        }
        return false;
    }

    public String longestDupSubstring(String S) {
        int len = S.length();
        if (len == 0) return "";

        // Store all rolling hash values
        roll = new int[len]; // Allocating fixed space to array
        roll[0] = 1; // Since 26^0 = 1
        for (int i = 1; i < len; ++i) {
            roll[i] = (26 * roll[i - 1]) % P;
        }

        int low = 1, high = len, mid;
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (low <= high) {
            temp.setLength(0); // Clear the StringBuilder
            mid = low + (high - low) / 2;
            boolean flag = match(S, len, mid, temp);
            if (flag) {
                if (temp.length() > ans.length()) {
                    ans.setLength(0); // Clear the StringBuilder
                    ans.append(temp);
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans.toString();
    }

    
}
