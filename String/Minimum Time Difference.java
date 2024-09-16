import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
          int  [] ans = new int [timePoints.size()];
          int n= ans.length;
            int index=0;
          for(String kid: timePoints)   {
            String hrs = kid.substring(0,2);
            int hrsMins= Integer.parseInt(hrs)*60;
            String mins = kid.substring(3, kid.length());
            int minsMins= Integer.parseInt(mins);
            ans[index]=hrsMins+minsMins;
            index++;
          }        
          Arrays.sort(ans);
          int result = Integer.MAX_VALUE;
          if( ans.length ==2){
            int ansTemp=Integer.MAX_VALUE;
               if( ans[0] ==0 ){
                     return Math.abs(ans[0]-(1440-ans[1]));
               }

               return Math.abs( ans[0]-ans[1]);
          }

          int zeroPrev = Math.abs( ans[n-1]-1440)+ans[0];
          result= Math.min(result,zeroPrev);
          
          for( int  i=1;i<=n-2;i++){
            int prev= ans[i]-ans[i-1];
            result=Math.min(result,prev);
            int next= ans[i+1]-ans[i];
            result=Math.min(result,next);
          }

          return result;


    }
}
