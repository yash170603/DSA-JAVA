// Start with the first element of the array.
// Find the minimum element in the remaining unsorted portion of the array.
// Swap the found minimum element with the first element of the unsorted portion.
// Move the boundary between the sorted and unsorted portions one element to the right.
// Repeat steps 2-4 until the entire array is sorted.

public class SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        
        selectionSort(arr);
        
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
