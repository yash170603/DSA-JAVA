class Solution {
    public int minimumDeletions(String ss) {
        Stack<Character> s= new Stack<>();
        int res=0;
       int n= ss.length();

       for( int i =0 ; i<n ; i++){     
             if( s.size()>0 && s.peek()=='b' && ss.charAt(i)=='a'){
                s.pop();
                res++;
             }  
             else 
          s.push(ss.charAt(i));
       }
        return res;
    }
}
