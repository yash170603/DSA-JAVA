class Solution {
    public boolean isValid(String s)
     {
        Stack<Character> s1 = new Stack<Character>();

        for(char ch : s.toCharArray())
        {
            if( ch == '(' || ch =='{' || ch == '[')
            s1.push(ch);

            else
            {
                if(s1.isEmpty()==true)
                return false;
                char chh = s1.pop();
                if( (chh =='(' && ch == ')')  ||  (chh =='{' && ch == '}')    || (chh =='[' && ch == ']') ) continue;
                else
                return false;

            }

        }
 
   if(s1.isEmpty() == true)
    return true;

    else 
    return false;
        
    }
}
