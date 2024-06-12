// class Solution {
//     public int shipWithinDays(int[] weights, int days) {
//         int max = 0;
//         int min = Integer.MAX_VALUE;
//         for( int x:weights)
//         {
//            max+=x;
//            min = Math.min(min,x);
//         }
//         int low = min;
//         int high = max;
//         while( low<=high)
//         {
//             int mid = (low+high)/2;

//             if( solve(mid,weights,days) <= days)
//             {
//                   high = mid-1;
//             }
//             else
                
//                 low = mid+1;
//         }

//         return low;

//     }

//     public int solve( int capacity, int[] arr,int days)
//     {     
//        int sum=0;
//        int ndays=0;
//        for( int index =0; index< arr.length;index++)
//        {
//          if( sum+arr[index] > capacity)
//          {
//             ndays++;
//             sum=0;
//             index--;
//          }
//          else
//           sum+=arr[index];
//        }
//      return ndays;    
//     }
// }
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = 0; // Minimum capacity should start from 0 or from the maximum weight in the array
        for (int x : weights) {
            max += x;
            min = Math.max(min, x); // Correctly setting min to the maximum weight
        }
        
        int low = min;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShipInDays(mid, weights, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShipInDays(int capacity, int[] weights, int days) {
        int currentLoad = 0;
        int requiredDays = 1; // Start with the first day, this had to be done
        
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        
        return requiredDays <= days;
    }
}
