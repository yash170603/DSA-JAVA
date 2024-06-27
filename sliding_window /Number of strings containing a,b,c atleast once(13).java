import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;
        
        for (char ch : "abc".toCharArray()) {
            map.put(ch, 0);
        }
        
        while (right < n) {
            map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            
            while (map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0) {
                count += n - right; // All substrings from left to right are valid
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            
            right++;
        }
        
        return count;
    }
}
