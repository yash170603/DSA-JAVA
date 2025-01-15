// so the gist was finding the least no of characters missing in front preventing this to be a palindrome

//    what is a palindrome? --> my thought was the lps arrays last element should be the half  of the length as the front is same as back, ,. but we dont know the full word , so cant go with this,
//         .
//     for palinddrome some sequence ( consective) subarray should match from behind, if we get that subpart, the answer will be the remaining no of character ,
//    for exampel.->  
//        s=abc
//             here we use standard palindrom matching trick - > s+"$"+rev(s)  .. this is mpre likely to be used in cases where palindromes are expected//


//                abc$bca  ->  lps[len(lps)-1]=1' telling that the longest prefix which is a palindrom is of length ==1 , so we need 3-1=2 characters to add at the biegginnning.

//         2nd example -> bcba   if bcba had to palindrom in rev-> abcb  

//                               bcba abcb we can see that the longest prefix palindrom and longest prefix palindrom is bcb , 
  
                 
//      longest prefix palindrome--> comes from bruteforce

//                        see      abcbacef
//                                 start with 0 and n-1.
//   if this s is not palindrom n-1 should be added.
//     then n-2. 
//    its not, add n-2,
//  then n-3, (c) its not , add n-3.
//     then n-4, it is a palindrom, so this means we have to add charcters which are to the right of this string, which is after "abcba" which is the longest prefix palindrome, 
//                                                                                                                                  |->    lps(abcacef+"$"+fecacba)=4, 4 shabd ase hai jo aage bhi hai, peeche bhi, then bache kitne n(7)- aage peeche k coomon- 7-4=3, ans.

  class Solution {
    public static int minChar(String s) {
        int n=s.length();
        StringBuilder ss = new StringBuilder(s);
         String rev = ss.reverse().toString();
          String append = s+"$"+rev;
           int [] lps= lpss(append);
             return n-lps[lps.length-1];
    }
    
    public static int [] lpss( String p){
          int n = p.length();
          int [] lps= new int[n];
           int prefix=0;
           int suffix = 1;
            
            while( suffix< n){
                
                   if(p.charAt(prefix) == p.charAt(suffix)){
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
}
