class Solution {
    public boolean checkValidString(String ss) {
        

         if(ss.length() ==0)
        {
            if(ss.charAt(0) == '*')
            {
                  return true;
            }
           return true;
        }
       
       int dp [][]= new int[101][101];
       for( int arr[]:dp)
       {
        Arrays.fill(arr,-1);
       }
       return  (solve(0,0,dp,ss) ==1 )?true:false;

    }

    public int solve( int currentindex, int count, int [][]dp, String s)
    {
        if( currentindex ==s.length())
        {
            if( count ==0)
            {
                return 1;
            }

            return 0;
        }

        if(dp[currentindex][count] !=-1)
        {
            return dp[currentindex][count];
        }
        

        boolean isokay = false;

        if( s.charAt(currentindex) == '*')
        {
            int a = solve( currentindex+1,count+1,dp,s);
            int b = solve( currentindex+1,count,dp,s);
            int c =0;
            if( count>0)
            {
                c= solve( currentindex+1, count-1,dp,s);
            }

            if( a==1|| b==1|| c==1)
            {
                isokay = true;
            }
        }

        // else  mai agar caharcter ( ho ya ) ho indono k liye do recursive calls daal ra tha instead ( liye sirf (ki recursive call jani chaiye
        // {
        //        int g = solve( currentindex+1,count+1,dp,s);
        //        int f =0;
        //         if( count>0)
        //     {
        //         f= solve( currentindex+1, count-1,dp,s);
        //     }
        //     if( g ==1 || f ==1)
        //     {
        //         isokay = true;
        //     }

        // }
         else if (s.charAt(currentindex)== '(') {
            // consider '('
            int g = solve(currentindex + 1, count + 1, dp, s);
            if (g == 1) {
                isokay = true;
            }
        } else {
            // consider ')'
            if (count > 0) {
                int f = solve(currentindex + 1, count - 1, dp, s);
                if (f == 1) {
                    isokay = true;
                }
            }
        }

        return dp[currentindex][count] = ((isokay) == true?1:0);
    }


}
