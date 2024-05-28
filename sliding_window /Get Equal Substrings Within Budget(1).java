class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
       int n = s.length();
       int i =0;
       int j=0;
       int ans =0;
       int len=0;
       int cp=0;
    

        while(i<n)
        {
           
           int  thiscost= Math.abs(s.charAt(i) - t.charAt(i));

            while( thiscost+cp> maxCost)
            {
                cp -=  Math.abs(s.charAt(j) - t.charAt(j));
                j++;
                len--;
            }

            cp+=thiscost;
            i++;
            len++;

               ans = Math.max(ans,len);
        }
  
        return ans;
    }
}
