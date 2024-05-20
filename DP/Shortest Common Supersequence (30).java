class Solution {
    
    public String shortestCommonSupersequence(String str1, String str2) {

        char[] s = str1.toCharArray(), t=str2.toCharArray();
        int n=str1.length(), m=str2.length();

        int dp[][] = new int[n+1][m+1];
        // base case
        for(int i=0; i<=n; i++) dp[i][0]=0;
        for(int j=0; j<=m; j++) dp[0][j]=0;

        // filling dp table and length of lcs
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(s[i-1]==t[j-1])
                dp[i][j]=1+dp[i-1][j-1];
                
                else 
                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i=n,  j=m;
        StringBuilder sb = new StringBuilder();
        // finding lcs from dp table
        while(i>0 && j>0)
        {
            // if current character matches
            if(s[i-1]==t[j-1]){
                sb.append(s[i-1]);
                i--; j--;
            }
            // if left cell is greater we will move left and will add char t[j-1] to ans.
            else if(dp[i-1][j] <= dp[i][j-1]){
                sb.append(t[j-1]);
                j--;
            }
            // up cell is greater we will move up and will add char s[i-1] to ans.
            else{
                sb.append(s[i-1]);
                i--;
            }
        }

        //adding remaining character of both string.
        while(i-->0) sb.append(s[i]);
        while(j-->0) sb.append(t[j]);
        
        return sb.reverse().toString();
    }
}





class Solution {
    HashMap<String,String> map;
    int n;
    int m;
    public String shortestCommonSupersequence(String str1, String str2) 
    {
        n= str1.length();
        m= str2.length();
        map = new HashMap<>();
        return solve(0,0,str1,str2);
    }

    public String solve( int index1, int index2,String s1, String s2)
    {
        if( index1 ==n || index2== m)
        {
            if(index1==n)
            {
                return s2.substring(index2,m);
            }

            return s1.substring(index1,n);
        }

        String key = index1+" "+index2;
        if(map.containsKey(key))
        {
            return map.get(key);
        }

        if( s1.charAt(index1) != s2.charAt(index2))
        {
            String a = s1.charAt(index1) + solve(index1+1,index2,s1,s2);
            String b = s2.charAt(index2) + solve(index1,index2+1,s1,s2);
            if(a.length()<b.length())
            {
                map.put(key,a);
                return a;
            }
            else
            map.put(key,b);
            return b;
        }
         
         String temp=s1.charAt(index1)+solve(index1+1,index2+1,s1,s2);
        map.put(key,temp);
        return temp;
    }
    
}
