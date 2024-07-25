Bucket Sort:
Time Complexity: 
O(n+k)
Space Complexity: 
𝑂(𝑛+𝑘)

Description: This algorithm distributes the elements into a number of buckets. 
Each bucket is then sorted individually (often using another sorting algorithm), 
and finally, the buckets are concatenated to form the sorted array. It's most effective when the input data is uniformly distributed over a range.


import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        // Create empty buckets
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add elements into the buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort the elements of each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets into the original array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.123f, 0.665f, 0.343f};
        bucketSort(arr);
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}



flow chart - 
Sure! Here’s a step-by-step explanation of the flowchart for Bucket Sort:

1. **Input the Array:**
   - Begin with the unsorted array of floating-point numbers.

2. **Create Buckets:**
   - Create an array of empty buckets. The number of buckets is often chosen based on the number of elements or the range of the values. Each bucket is usually an `ArrayList` or similar data structure to handle multiple values.

3. **Distribute Elements into Buckets:**
   - Traverse the input array and place each element into the appropriate bucket based on its value. For example, if the value is in the range `[0, 1)`, it could be placed in bucket `index = (int)(value * numberOfBuckets)`.

4. **Sort Each Bucket:**
   - Sort the elements within each bucket. This is usually done using a comparison-based sorting algorithm like insertion sort or quicksort.

5. **Concatenate Buckets:**
   - Concatenate all the sorted buckets into a single array. This step combines the sorted elements from each bucket to form the final sorted array.

6. **End:**
   - The input array is now sorted.

### Flowchart Diagram

1. **Start**
   - Input array: `[0.897, 0.565, 0.656, 0.123, 0.665, 0.343]`

2. **Create Buckets**
   - Initialize an array of empty buckets:
     - `buckets[]`: `[[], [], [], [], [], []]` (assuming 6 buckets for this example)

3. **Distribute Elements into Buckets**
   - Place each element into the appropriate bucket:
     - `0.897` goes into bucket `5`
     - `0.565` goes into bucket `3`
     - `0.656` goes into bucket `3`
     - `0.123` goes into bucket `0`
     - `0.665` goes into bucket `3`
     - `0.343` goes into bucket `2`
   - Buckets after distribution:
     - `buckets[]`: `[[0.123], [ ], [0.343], [0.565, 0.656, 0.665], [ ], [0.897]]`

4. **Sort Each Bucket**
   - Sort each bucket individually:
     - Bucket `0`: `[0.123]` (already sorted)
     - Bucket `2`: `[0.343]` (already sorted)
     - Bucket `3`: `[0.565, 0.656, 0.665]` (sorted)
     - Bucket `5`: `[0.897]` (already sorted)

5. **Concatenate Buckets**
   - Merge the sorted buckets into a single array:
     - Resulting array: `[0.123, 0.343, 0.565, 0.656, 0.665, 0.897]`

6. **End**

### Summary of Bucket Sort

1. **Start** with an unsorted array.
2. **Create Buckets** and initialize them.
3. **Distribute Elements** into appropriate buckets.
4. **Sort Each Bucket** using a comparison-based algorithm.
5. **Concatenate** the sorted buckets into the final sorted array.
6. **End** with the sorted array.

Bucket Sort works well when the input values are uniformly distributed over a range.
  The choice of the number of buckets and the sorting algorithm used for the buckets can affect the efficiency of the algorithm.



count sort - 
  time complexity - o(n+k)
  space= o(k)


  public class CountingSort {

    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Find the maximum element in the array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a count array to store the count of each element
        int[] count = new int[max + 1];

        // Initialize the count array with all zeros
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Store the cumulative count
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element and place it in the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements into the original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}



flowcahrt

  Certainly! Here is a step-by-step explanation of the flowchart for Counting Sort:

1. **Input the Array:**
   - Begin with the unsorted array of integers.

2. **Find the Maximum Value:**
   - Traverse the array to determine the maximum value (`max`) in the array. This helps in determining the range of the `count` array.

3. **Initialize the Count Array:**
   - Create a `count` array of size `max + 1`, initialized to zero. This array will store the count of each unique integer in the input array.

4. **Store the Counts:**
   - Traverse the input array again, and for each element `arr[i]`, increment the count in the `count` array at the index corresponding to the value of `arr[i]`.

5. **Calculate Cumulative Counts:**
   - Modify the `count` array such that each element at index `i` contains the sum of the previous counts. This step transforms the `count` array such that each position `i` contains the number of elements less than or equal to `i`.

6. **Build the Output Array:**
   - Create an output array of the same length as the input array.
   - Traverse the input array in reverse order to maintain the stability of the sorting algorithm (stability means that equal elements retain their relative order). For each element `arr[i]`, place it in its correct position in the `output` array by using the `count` array to determine the correct index. Decrement the corresponding count in the `count` array after placing the element.

7. **Copy Output to Original Array:**
   - Copy the sorted elements from the `output` array back to the original input array.

8. **End:**
   - The input array is now sorted.

### Flowchart Diagram

1. **Start**
   - Input array: `[4, 2, 2, 8, 3, 3, 1]`

2. **Find Maximum Value**
   - Max value (`max`): `8`

3. **Initialize Count Array**
   - `count[]`: `[0, 0, 0, 0, 0, 0, 0, 0, 0]`

4. **Store the Counts**
   - For each element in the input array, increment the count:
     - After processing `4`: `count[]`: `[0, 0, 0, 0, 1, 0, 0, 0, 0]`
     - After processing `2`: `count[]`: `[0, 0, 1, 0, 1, 0, 0, 0, 0]`
     - After processing `2`: `count[]`: `[0, 0, 2, 0, 1, 0, 0, 0, 0]`
     - After processing `8`: `count[]`: `[0, 0, 2, 0, 1, 0, 0, 0, 1]`
     - After processing `3`: `count[]`: `[0, 0, 2, 1, 1, 0, 0, 0, 1]`
     - After processing `3`: `count[]`: `[0, 0, 2, 2, 1, 0, 0, 0, 1]`
     - After processing `1`: `count[]`: `[0, 1, 2, 2, 1, 0, 0, 0, 1]`

5. **Calculate Cumulative Counts**
   - Transform the `count` array to cumulative counts:
     - `count[]`: `[0, 1, 3, 5, 6, 6, 6, 6, 7]`

6. **Build the Output Array**
   - Initialize `output[]` of the same length as the input array:
   - Traverse the input array in reverse order to place elements in the `output` array:
     - For `1`: `output[]`: `[1, 0, 0, 0, 0, 0, 0]`, `count[]`: `[0, 0, 3, 5, 6, 6, 6, 6, 7]`
     - For `3`: `output[]`: `[1, 0, 0, 3, 0, 0, 0]`, `count[]`: `[0, 0, 3, 4, 6, 6, 6, 6, 7]`
     - For `3`: `output[]`: `[1, 0, 0, 3, 3, 0, 0]`, `count[]`: `[0, 0, 3, 3, 6, 6, 6, 6, 7]`
     - For `8`: `output[]`: `[1, 0, 0, 3, 3, 0, 8]`, `count[]`: `[0, 0, 3, 3, 6, 6, 6, 6, 6]`
     - For `2`: `output[]`: `[1, 2, 0, 3, 3, 0, 8]`, `count[]`: `[0, 0, 2, 3, 6, 6, 6, 6, 6]`
     - For `2`: `output[]`: `[1, 2, 2, 3, 3, 0, 8]`, `count[]`: `[0, 0, 1, 3, 6, 6, 6, 6, 6]`
     - For `4`: `output[]`: `[1, 2, 2, 3, 3, 4, 8]`, `count[]`: `[0, 0, 1, 3, 5, 6, 6, 6, 6]`

7. **Copy Output to Original Array**
   - Copy the `output` array back to the input array:
   - Sorted array: `[1, 2, 2, 3, 3, 4, 8]`

8. **End**

This detailed explanation outlines each step involved in the Counting Sort algorithm, from initialization to the final sorted array.












  heap sort->
  class Solution {
    public void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }

        return nums;
    }
}
Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. Its time complexity can be analyzed as follows:

### Time Complexity

1. **Building the Heap:**
   - Building the max-heap (or min-heap) from an unsorted array takes \(O(n)\) time. This is because the heapify operation, when applied to each node in a bottom-up manner, results in a linear time complexity.

2. **Extracting Elements from the Heap:**
   - Extracting the maximum (or minimum) element from the heap and re-adjusting the heap (heapify) takes \(O(\log n)\) time per extraction.
   - Since we need to extract \(n\) elements, this part of the algorithm has a time complexity of \(O(n \log n)\).

### Overall Time Complexity

Combining both parts:

- **Building the Heap:** \(O(n)\)
- **Extracting Elements:** \(O(n \log n)\)

Thus, the overall time complexity of Heap Sort is \(O(n \log n)\).

### Space Complexity

- **Space Complexity:** Heap Sort is an in-place sorting algorithm, meaning it sorts the array without using additional space proportional to the size of the input array. Hence, its space complexity is \(O(1)\) (excluding the space used by the input array itself).

### Summary

- **Best-case Time Complexity:** \(O(n \log n)\)
- **Average-case Time Complexity:** \(O(n \log n)\)
- **Worst-case Time Complexity:** \(O(n \log n)\)
- **Space Complexity:** \(O(1)\)
