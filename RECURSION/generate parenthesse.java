class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> ans = new ArrayList<>();
        solve(0,0,n,ans,"");
        return ans;
    }
    public  void solve( int open, int close, int n , List<String> ans ,String temp)
    {
        if (temp.length() == n * 2) {
            ans.add(temp);
            return;
        }

        if( open<n)
        {
            solve( open+1,close,n,ans,temp+"(");
        }

         if( close<open)
        {
            solve( open,close+1,n,ans,temp+")");
        }
     return;
    }
}
