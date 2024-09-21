class Solution {
    public List<Integer> diffWaysToCompute(String s) {
          int n = s.length();
          if( s.equals("0") || ( !s.contains("+")&& !s.contains("-")&& !s.contains("*"))){
            List<Integer> mc= new ArrayList<>();
            if(s.equals("0") ){
                   mc.add(0);
                 return mc;
            } 
            mc.add(Integer.parseInt(s));
            return mc;
          }
         List<Integer> ans = new ArrayList<>();
          for( int i=0;i<n;i++){
              char op = s.charAt(i);
              if( !Character.isDigit(op)){
                
                    List<Integer>  res = solve(s.substring(0,i));
                    List<Integer>  res2 = solve(s.substring(i+1,n));
                   // int u=res.get(0);
                    for( int u: res){
                          for( int v: res2){
                                if(op =='+') ans.add(u+v) ; 
                                if(op=='-') ans.add(u-v) ;
                                if(op=='*') ans.add(u*v) ;
                          }
                    }
              }    
          }

          return ans;
    }

    public List<Integer> solve(String s){
           if( !s.contains("+")&& !s.contains("-")&& !s.contains("*"))
           {
              List<Integer> temp= new ArrayList<>();
              temp.add(Integer.parseInt(s));
              return temp;
           }
          
          List<Integer> a = new ArrayList<>();
        //    if( ( s.contains("+")|| s.contains("-")|| s.contains("*"))  && s.length() ==3){
        //        char op= s.charAt(1);
        //        int d1=s.charAt(0)-'0';
        //        int d2 = s.charAt(2)-'0';
        //        List<Integer> g = new ArrayList<>();
        //        if( op =='+') g.add(d1+d2) ; 
        //        if(op=='-') g.add(d1-d2) ;
        //        if(op=='*') g.add(d1*d2) ;
        //        return g;
        //    }

           for( int i=0; i<s.length();i++){
                 char ch = s.charAt(i);
                 if( ! Character.isDigit(ch)){
                       List<Integer> p= solve(s.substring(0,i));
                       List<Integer> q = solve( s.substring(i+1,s.length()));
                   
                         for( int u: p){
                          for( int v: q){
                                if(ch =='+') a.add(u+v) ; 
                                if(ch=='-') a.add(u-v) ;
                                if(ch=='*') a.add(u*v) ;
                          }
                    }
                 }  
           }

           return a;
    }

}
