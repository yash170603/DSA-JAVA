//could have been done with an aarray
class Solution {
    public boolean checkInclusion(String s1, String s2) {
          int n= s1.length(),m=s2.length();
          if(n>m) return false;
          HashMap<Character,Integer> map1 = new HashMap<>();
          HashMap<Character,Integer> map2 = new HashMap<>();
          int req=0;
          for( char ch: s1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            req++;
          }
          int  formed=0;
          int i=0,j=0;
          while(i<m){
            char ch = s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if( map1.containsKey(ch) && map1.get(ch)>=map2.get(ch)) formed++;

            if( i-j+1>n){
              char dump= s2.charAt(j);
              map2.put(dump,map2.get(dump)-1);
              if( map1.containsKey(dump) && map1.get(dump)>map2.get(dump)) formed--;
              if( map2.get(dump)==0) map2.remove(dump);
              j++;
            }
            if( formed == req) return true;
            i++;
          }

          return false;
    }
}
