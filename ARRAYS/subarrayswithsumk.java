import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) 
    {
       HashMap<Integer,Integer> mp = new HashMap<>();
       mp.put( 0,1);
      int csum =0;
      int count =0;
       int n = nums.length;
       for( int i=0;i<n;i++)
       {
           csum+=nums[i];
           if( mp.containsKey(csum-k))
           count += mp.get(csum-k);
           mp.put( csum, mp.getOrDefault(csum,0)+1);

       }

       return count;
    }
}
