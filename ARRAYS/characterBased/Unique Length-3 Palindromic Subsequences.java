class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        for( char ch='a';ch<='z';ch++){
             int f=s.indexOf(ch);
             int l=s.lastIndexOf(ch);
             HashSet<Character> ss= new HashSet<>();
             for(int i=f+1;i<l;i++){
                   ss.add(s.charAt(i));
             }
             ans+=ss.size();
        }
        return ans;
    }
}
