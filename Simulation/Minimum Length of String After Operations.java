class Solution {
    public int minimumLength(String s) {
          
            int  [] freq = new int [26];
         
              for( char ch :s.toCharArray()){
               freq[ch-'a']++;
             }
                for( int i=0;i<freq.length;i++){
                       if( freq[i]>=3){
                               if( freq[i]%2==0){
                                   freq[i]=2;
                               }
                               else{
                                 freq[i]=1;
                               }
                       }
                }

                int count =0;
                 for( int v: freq){
                      count+=v;
                 }

                 return count;
         
    }
}
