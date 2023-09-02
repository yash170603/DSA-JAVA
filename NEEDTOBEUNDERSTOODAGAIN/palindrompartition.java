class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>al=new ArrayList<>();
        List<String>ds=new ArrayList<>();
        check(s,al,ds);
        return al;
    }
    public static void check(String s,List<List<String>>al,List<String>ds){
        if(s.length()==0){
            al.add(new ArrayList<>(ds));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String s1=s.substring(0,i);
            if(palin(s1)){
                ds.add(s1);
                check(s.substring(i,s.length()),al,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public static boolean palin(String s){
        int i=0,j=s.length()-1;
        while(j>=i){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
