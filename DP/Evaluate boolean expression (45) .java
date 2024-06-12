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
