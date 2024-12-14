2129/2135
  class Solution {
    public long continuousSubarrays(int[] nums) {
        int n= nums.length;
         HashSet<Integer> s = new HashSet<>();
         for( int u: nums){
            s.add(u);
         }
        long ans=0;
        int i=0;
        int prev=-1;
        while( i<n ){
               int j=i;
               while( j>=0 && j>prev ){
                if(Math.abs( nums[i]-nums[j])<=2)
                  j--;
                  else{
                    prev=j;
                    break;
                  }
               }
               ans+=i-j;
               i++;
        }
        return ans; 
    }
}



//  passed'


class Solution {
    public long continuousSubarrays(int[] nums) {
       int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0;
        long count = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (Math.abs(map.lastKey() - map.firstKey()) > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}
