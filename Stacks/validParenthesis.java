//passes23/59 cases  does not passes brackets insiide of superbrcakets

  import java.util.Stack;
class Solution {
    public String removeOuterParentheses(String s) 
    {
          Stack<Character> s1 = new Stack<Character>();StringBuilder ans= new StringBuilder();
         
      for(char ch : s.toCharArray())
        {
            if( ch == '(')
            s1.push(ch);

            else
            {
               char ch1 = s1.pop();
               if(s1.isEmpty() == true)
               continue;

              else
              ans.append(ch1).append(ch);


            }

        }
         

        return ans.toString();

    }

}


// Input: s = "(()())(())(()(()))"
//Output: "()()()()(())"
import java.util.Stack;
class Solution {
    public String removeOuterParentheses(String s) 
    {
          Stack<Character> s1 = new Stack<Character>();StringBuilder ans= new StringBuilder();
         
      for(char ch : s.toCharArray())
        {
            if( ch == '(')
            {
                if(s1.size()>0)
                {
                    ans.append(ch);
                }
            s1.push(ch);
            }
          

            else
            {
             s1.pop();
               if(s1.size()>0)
               {
              ans.append(ch);
               }

             
             


            }

        }
         

        return ans.toString();

    }

}





