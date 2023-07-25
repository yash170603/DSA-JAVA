public class MergeSort {

    // Main merge sort method
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return; // Base case: already sorted
        }

        // Divide the array into two halves
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // Copy data into left and right arrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    // Merge two subarrays into one sorted array
    public static void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        // Merge elements from both arrays in sorted order
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from left and right arrays
        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
