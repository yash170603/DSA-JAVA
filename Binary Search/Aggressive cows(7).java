class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int s = 0;
        int e = stalls[n - 1] - stalls[0];
        int result = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (ispossible(mid, stalls, k)) { // i am passing the min distance, i need maximum min distance
                result = mid;  // Update result to mid if it's possible
                s = mid + 1;   // Try for a larger minimum distance
            } else {
                e = mid - 1;   // Try for a smaller minimum distance
            }
        }

        return e; // return ans;
    }
   public static boolean ispossible(int dist, int[] stalls, int cows) {
        int count = 1;
        int pindex = 0;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[pindex] >= dist) {
                count++;
                pindex = i;
            }

            if (count == cows) {
                return true;
            }
        }

        return false;
    }
}




// **Sorting**: Sorting the stalls array takes \(O(n \log n)\) time, where \(n\) is the number of stalls.

// 2. **Binary Search**: The binary search runs over the possible distances, which range from 0 to the maximum possible distance, \(d\). This range is \([0, stalls[n-1] - stalls[0]]\). The binary search requires \(O(\log d)\) steps, where \(d\) is the difference between the maximum and minimum stall positions. In each step of the binary search, we perform the feasibility check.

// 3. **Feasibility Check**: The feasibility check iterates through the stalls to place the cows, which takes \(O(n)\) time.

// Combining these, the overall time complexity can be expressed as:

// O(n log n) + O(log d*n)
