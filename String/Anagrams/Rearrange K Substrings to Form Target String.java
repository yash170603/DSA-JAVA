import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> freq = new HashMap<>();

        // Populate frequency map for string `s`
        int segmentLengthS = s.length() / k;
        for (int i = 0; i < s.length(); i += segmentLengthS) {
            String segment = s.substring(i, i + segmentLengthS );
            freq.put(segment, freq.getOrDefault(segment, 0) + 1);
        }

        // Adjust frequency map for string `t`
        int segmentLengthT = t.length() / k;
        for (int i = 0; i < t.length(); i += segmentLengthT) {
            String segment = t.substring(i, i + segmentLengthT );
            freq.put(segment, freq.getOrDefault(segment, 0) - 1);
        }

        // Check if all frequencies are zero
        for (int count : freq.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
