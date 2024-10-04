import java.util.*;
class Solution {
    public long dividePlayers(int[] nums) {

       Arrays.sort( nums);
       int tot = 0;
       for(int i: nums){
        tot+=i;
       }
       int n=nums.length;
       int teams=n/2;
       if( tot%teams!=0) return -1;
       int ppt=tot/teams;
       HashMap<Integer,Integer> map = new HashMap<>();
       for( int i =0;i<n;i++){
          int val = nums[i];
          if(!map.containsKey(val)){
            map.put(val,1);
          }
           else{
            map.put(val,map.get(val)+1);
           }
       }
       long sum=0;

         for( int i =0;i< n && map.size()>0;i++){
              if(!map.containsKey( ppt-nums[i])) return -1;
              else{
                     sum+=(long)(nums[i]*(ppt-nums[i]));
                  
                     map.put(nums[i],map.get(nums[i])-1);
                     if( map.get(nums[i])==0){
                        map.remove(nums[i]);
                     }
                    map.put(ppt-nums[i],map.get(ppt-nums[i])-1);
                     if( map.get(ppt-nums[i])==0){
                        map.remove(ppt-nums[i]);
                     }

              }
         }

         return sum;
    }
}
