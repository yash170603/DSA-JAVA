//Certainly! Kadane's algorithm is used to find the maximum sum subarray within a given array of integers.
//It has a time complexity of O(n), making it an efficient solution to this problem.

public class KandanesAlgorithm {

    public static int kadanesAlgorithm(int[] arr) {
        int maxEndingHere = arr[0]; // Maximum sum ending at the current position
        int maxSoFar = arr[0];      // Maximum sum encountered so far

        for (int i = 1; i < arr.length; i++) {
            // Choose the maximum between the current element and the current element + maxEndingHere
            maxEndingHere = Math.max(arr[i], arr[i] + maxEndingHere);
            // Update maxSoFar if the new maxEndingHere is greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Array: " + Arrays.toString(arr));

        int maxSum = kadanesAlgorithm(arr);
        System.out.println("Maximum sum of a subarray: " + maxSum);
    }
}
