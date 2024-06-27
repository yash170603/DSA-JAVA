class Solution {
    public int minAddToMakeValid(String ss) {
        Stack<Character> s= new Stack<>();
        for( char ch:ss.toCharArray())
        {
            if( ch =='(')
            s.push(ch);
            else if( ch ==')' && !s.isEmpty())
            {
                if( s.peek()=='(')
                 s.pop();

                 else
                 s.push(ch);
            }
            else if (ch==')' && s.isEmpty())
            s.push(ch);
        }
        return s.size();
    }
}


// better
class Solution {
    public int minAddToMakeValid(String s) {
        int leftBraceCount = 0, rightBracesRequired = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') leftBraceCount += 1;
            else {
                if(leftBraceCount == 0) { rightBracesRequired += 1; continue; }
                leftBraceCount -= 1;
            }
        }
        return leftBraceCount + rightBracesRequired;
    }
}
