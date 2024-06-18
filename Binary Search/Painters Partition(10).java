import java.util.ArrayList;
import java.util.*;
public class Solution 
{
        public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int max= Integer.MIN_VALUE;
        for( int y:boards)
        {
            max= Math.max(y,max);
        }
        int ltu = max; // leats time unit per painter assigned, one should be able to paint atleast the highest board
        int mtu =0;// most time units allowwed for a painter
        for( int u : boards)
        {
            mtu+=u;
        }
           int i=ltu;
           int j=mtu;
           int ans=mtu;
        while (i <= j) {
            int mid = (i + j) / 2;

            int painters = solve(mid, boards);
            if (painters > k) { // painters jayada hore total no of boards k liye, so allowed units ko badao
                i = mid + 1;
            } else {
                
                ans = mid;
                j = mid - 1;
            }
        }
        return ans;
    }
    public static int solve( int nou, ArrayList<Integer> x) // nou = no of units allowed for a painter
    {
          int cursum =0;
          int nop =1;  // no of painter

          for( int i =0;i<x.size();i++)
          {
              if( cursum+x.get(i)<=nou)
              {
                  cursum+=x.get(i);
              }
              else{
                  nop++;
                  cursum= x.get(i);
              }
          }

          return nop;

    }
}
