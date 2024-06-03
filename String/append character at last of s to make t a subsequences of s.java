class Solution {
    public int appendCharacters(String s, String t) {
        
        if( s.length()==0)
        {
            return t.length();
        }
        if( t.length() ==0  || (t.length()==1 && s.contains(t)))
        {
            return 0;
        }
        int sindex=0;
        int tindex =0;
      while(sindex< s.length() && tindex<t.length())
      {
        if( s.charAt(sindex) == t.charAt(tindex))
        {        
            tindex++;       
        }
          sindex++;
      }
        return (t.length()-tindex);
    }
}
