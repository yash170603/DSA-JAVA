class Solution {
    int median(int matrix[][], int R, int C) {
        
        int k = (R*C)/2;    // median position
        // int the combined array elemenst <= to the element at median position that is at arr[k]   is always greater than k, i.e half of the array n/2
         // 1,2,3,4,5,7,7,7,8,9,10
         //           ^ median position (k), elements less than equal to arr[k] = 1,2,3,4,5,7,7,7, > n/2
          //                                                                     first half ^ second half
          
          // point is could have been ay array as 1,1,1,1,1,1,1
          //                                            ^        elemts <= to arr[k] = 7 which is > n/2.
          // toh final answer mei wo median hoga jiske andar no of elements less than the number is greater than n/2.
          
          
           int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
          for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, R, C, mid);
            if (smallEqual <= k) low = mid + 1;  // agar no of elemts <= to this mid is not greater than n/2,-> not a median increase the range
            else high = mid - 1;
        }
        return low;

         
    }
    
     int countSmallEqual(int[][] matrix, int R, int C, int x) {
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            cnt += upperBound(matrix[i], x, C);// har ek row  bheji jari hai , to find no of elemnts less than x, x is a potential median, if elemets less than this would be greater than n/2 this will be answer
        }
        return cnt;
    }
      int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    
}
