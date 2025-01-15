// // gist was ki, for b to a substring of a, a,s lenght should be atleast of lenghts of b
// ,, so we add s continulisly that times.


// if the string isnt in this length, we try one more time,
// agar usme bhi nahi hai
// , then toh possible hi  nahi hai.


class Solution {
    public int repeatedStringMatch(String a, String b) {
          
           if(a.equals(b)) return 1;
           int init = 0;
        StringBuilder sb = new StringBuilder();
         int times = Math.ceilDiv(b.length(), a.length());
              while( times-->0){
                 sb.append(a);
                 init++;
              }
                
                if( isThere(b,sb.toString()))
                return init;
                sb.append(a);
                 if(isThere(b,sb.toString()))
                 return init+1;
            
            return -1;

    }

        public int [] lps( String s){
               int n= s.length();
                int [] lps= new int[n];
                 int prefix=0;
                 int suffix=1;
                  while(suffix<n){
                          if( s.charAt(prefix)==s.charAt(suffix)){
                               prefix++;
                               lps[suffix]=prefix;
                                 suffix++;
                          }
                          else{
                              if(prefix!=0){
                                 prefix= lps[prefix-1];
                              }
                              else{
                                    lps[suffix]=0;
                                    suffix++;
                              }
                          }
                  }

                    return lps;
                  
        }

        public boolean isThere(String pattern, String text){
               int n= text.length();
               int m= pattern.length();
               int [] lps= lps(pattern);
               int i=0;
               int j=0;
               while(i<n){
                     if(text.charAt(i)==pattern.charAt(j)){
                          i++;
                          j++;
                     }
                     if(j==m){
                          return true;
                     }
                     else if(i<n && text.charAt(i)!=pattern.charAt(j)){
                          if(j!=0){
                               j= lps[j-1];
                          }
                          else{
                               i++;
                          }
                     }
               }
               return false;
               
        }
}
