bf->
  class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for( int a:nums){
            max=Math.max(max,a);
            min=Math.min(min,a);
        }
        int [] val= new int[max+1];
        Arrays.fill(val,0);
        int n = nums.length;

        for( int i =1;i<n;i++){
            for( int j=0;j<i;j++){
                int diff= Math.abs( nums[i]-nums[j]);
                val[diff]++;
            }
        }
      int count=0;
      int index=0;
      while( true){
        if( count+val[index]<k){
            count+=val[index];
            index++;
        }
        else if( val[index]+count>=k){
            return index;
        }
      }

      //return -1;
    }
}

//optimal
import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;
            int count = countPairs(nums, mid);
            
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countPairs(int[] nums, int diff) {
        int count = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= diff) {
                j++;
            }
            count += (j - i - 1);
        }
        return count;
    }
}
