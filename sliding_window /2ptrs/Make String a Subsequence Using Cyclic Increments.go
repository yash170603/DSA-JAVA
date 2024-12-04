//golang code
func canMakeSubsequence(s1 string, s2 string) bool {
    i, j:= 0, 0
    n, m:= len(s1),len(s2)
    for i < n && j < m {
        ch:=rune(s1[i])  // Convert byte to rune
        nextC:=nextChar(ch)  // Fixed variable name and added nextChar call
        if nextC==rune(s2[j])||ch==rune(s2[j]){
            j++
        }
        i++
    }
    return j==m
}

func nextChar(ch rune) rune {
    if ch=='z' {
        return 'a'
    } else {
        return ch + 1  // Fixed to use ch instead of rune
    }
}



// optimised java code
class Solution {
    public boolean canMakeSubsequence(String s1, String s2) {
           int i=0,j=0,n=s1.length(),m=s2.length();

           while( i<n && j<m){
                if(  s1.charAt(i) ==s2.charAt(j)){
                    i++;
                    j++;
                }
                else if( s1.charAt(i) !=s2.charAt(j) ){
                       
                       char ch =  s1.charAt(i);
                       ch = ch-'a'==25?'a': (char)((int)ch+1);
                        
                         if( ch != s2.charAt(j) ){
                            i++;
                         }
                         else{
                            i++;
                            j++;
                         }
                }
           }

           return j==m;
    }
}
