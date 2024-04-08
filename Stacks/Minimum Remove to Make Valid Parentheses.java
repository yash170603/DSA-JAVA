/*question was to remove all invalid parenthese, invalid tabhi hoga jab extra ) ya toh ( hoga, */

class Solution {
    public String minRemoveToMakeValid(String s) {

        int n = s.length();
        HashSet<Integer> harami = new HashSet<Integer>();
        Stack<Integer> ss = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                ss.push(i);  // iski invalid ness baad mei check hori, neeche
            }

            else if (s.charAt(i) == ')') {
                if (ss.isEmpty()) {
                    harami.add(i);
                }   // q khali aur ) aya toh dikkat krega 

                else {
                    ss.pop(); // agar pehle se ( tha and ab ) aya toh proper parenteses hai pop kro isko ( and ) isko add mat kro
                }
            }

        }

        while (!ss.isEmpty()) {
            harami.add(ss.pop()); // idhar ( iski invalid ness check hori, ed (() 1 and 2 index wale cancel ho jare, ab q mei sirf( ye bacha hai haramipana krne ko, so ass kr dia
        }

        String ans = "";

        for (int u = 0; u < n; u++) {
            if (!harami.contains(u)) {
                ans += s.charAt(u);
            }
        }

        return ans;
    }
}
