//bruteforce// tle at first
class Solution {
    public String minWindow(String s, String t) {
        int i=0,j=0,max=0,n=s.length();
        String ans="",temp="";
        while( i < n)
        {
            temp+= Character.toString(s.charAt(i));
            if( check(temp,t))
            {
                int curlength = temp.length();
                max = Math.max(max,curlength);
                ans="";
                ans+=temp;
                int a= 0,b=curlength;
                while( a<b)
                {
                    String subs= temp.substring(a,b);
                    if( check(subs,t)==true)
                    {
                        if( subs.length() < max)
                        {
                            max= Math.min(max,subs.length());
                            ans="";
                            ans+=subs;
                        }
                    }
                    a++;
                }
                 i= curlength;
                 temp="";
            }
                i++;    
        }
        return ans;
    }
    public boolean check( String window, String t)
    {
       char[] ch = t.toCharArray();
    for (char c : ch) {
        if (!window.contains(Character.toString(c))) {
            return false;
        }
    }
    return true;
    }
}





// sliding window
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Character frequency map for t
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // Character frequency map for the sliding window
        Map<Character, Integer> mapWindow = new HashMap<>();
        int left = 0, right = 0, formed = 0, minLength = Integer.MAX_VALUE;
        int[] ans = {-1, 0, 0};  // length, left, right

        // Total unique characters in t to be matched
        int required = mapT.size();

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            mapWindow.put(c, mapWindow.getOrDefault(c, 0) + 1);

            // If the current character's frequency matches with t's frequency
            if (mapT.containsKey(c) && mapWindow.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window until it ceases to be 'valid'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the smallest window found
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    ans[0] = minLength;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove characters from the left of the window
                mapWindow.put(c, mapWindow.get(c) - 1);
                if (mapT.containsKey(c) && mapWindow.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
