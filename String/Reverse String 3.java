/* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"*/

class Solution {
    public String reverseWords(String s)
     {
        StringBuilder s2= new StringBuilder();
       
        s = s+" ";
        ArrayList<String> x = new ArrayList<String>();
        int i=0;


        for(int j=0;j<s.length();j++)
        {
            if(s.charAt(j) != ' ')
            continue;

            else
            {
                    String s1 = s.substring(i, j);
                    x.add(s1);
                    s1="";
                    i=j+1;
            }
        }

        for(String d : x)
        {
            String l = function(d);
              s2.append(l).append(" ");
              l="";
        }

        String d= s2.toString();
        String q= d.substring(0, d.length()-1);
        return q;
    }

     public String function(String s)
    {
       
        int x = s.length();

        StringBuilder ans = new StringBuilder();
        

        for(int a=x-1;a>=0;a--)
        {
             ans.append(s.charAt(a)) ;
            
        }

        return ans.toString();
    }
}
