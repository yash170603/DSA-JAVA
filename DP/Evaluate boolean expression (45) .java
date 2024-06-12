// passed 70/75

class Solution {
    public Boolean dp[][];
    public boolean parseBoolExpr(String expression) {
 
        int n = expression.length();
        dp = new Boolean[n+1][n+1];
        return solve(0,n-1,expression);
    }
    public boolean solve( int i, int j ,String e)
    {
        if( i+3 ==j  )
        { 
            char oper= e.charAt(i);

            Boolean f = (e.charAt( i+2)=='f')?false:true;

            if( f == false &&oper =='|')
            return true;
            if( f ==false && oper =='&')
            return false;

            return !f;
        }      
        if( dp[i][j] != null)
        return dp[i][j];
        char op = e.charAt(i);
        char op1= e.charAt(i+2); // checking if an operator exits after this 
        if(  op1 =='|'|| op1=='&'|| op1=='!')
        { 
            if( op=='|')
            {
                boolean ans = false;
                return dp[i][j]= ans| solve( i+2, j-1, e);
            }
            else if( op=='&')
            {
                boolean ans = false;
                return dp[i][j]= ans & solve( i+2,j-1,e );
            }
            else 
              {
                return dp [i][j]= (solve(i+2,j-1,e)==true)?false:true;
              }           
         }// cases when there still operators left in the expression          
        // op is the opearator at current palce
        // 3 different loops, for each operator, from i+2 to <j
      boolean ans = false;        
           if( op== '|')
           {
               Boolean temp = (e.charAt(i+2) =='f')?false:true;
                 for( int  k = i+3;k<j;k++)
                  {
                    
                     if( e.charAt(k) == ',')
                      {
                         continue;
                      }
                        Boolean var = (e.charAt(k) =='f')?false:true;
                        temp = temp|var;
                   }
                   ans=temp;
            }
            else if( op== '&')
            {  
                Boolean temp = (e.charAt(i+2) =='f')?false:true;
                for( int  k = i+3;k<j;k++)
                  {
                     if( e.charAt(k) == ',')
                      {
                         continue;
                      }
                        boolean var = (e.charAt(k) =='f')?false:true;
                        temp = temp&var;
                   }       
                   ans =temp;   
                       
            }    

            else 
            {
                 ans=  (e.charAt(i+2) =='f')?true:false; 
            }
      return dp[i][j]= ans;

    }
}




// coorerct
class Solution {
    private int idx = 0;

    public boolean parseBoolExpr(final String expression) {
        this.idx = 0;

        if(expression.length() == 1)
            return expression.charAt(0) == 't';
        
        return this.helper(expression);
    }

    private boolean helper(final String s) {
        final char operator = s.charAt(this.idx);

        this.idx += 2;
        
        char c = s.charAt(this.idx);

        boolean result = false;

        if(c == 't') {
            result = true;
            this.idx++;
        } else if(c == 'f') {
            result = false;
            this.idx++;
        } else {
            result = this.helper(s);
        }

        c = s.charAt(this.idx);

        while(c != ')') {
            if(c == ',') {
                c = s.charAt(++this.idx);
                continue;
            }

            boolean curr = false;

            if(c == 't') {
                curr = true;
                this.idx++;
            } else if(c == 'f') {
                curr = false;
                this.idx++;
            } else {
                curr = helper(s);
            }

            if(operator == '&')
                result &= curr;
            else if(operator == '|')
                result |= curr;

            c = s.charAt(this.idx);
        }

        this.idx++;

        return operator == '!' ? !result : result;
    }
}
