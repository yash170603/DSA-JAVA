import java.util.*;
class Solution {
    public int largestCombination(int[] candidates) {
        int [] arr = new int [32];
        int ans=Integer.MIN_VALUE;
        for( int x :candidates){
              for(int bit=0;bit<32;bit++){
                  int thisBit= (x>>bit)&1;
                  if(thisBit==1) arr[bit]++;
              }
        }
        
        for(int d:arr){
            ans=Math.max(ans,d);
        }

        return ans;
    }
}
