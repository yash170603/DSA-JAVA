// Start with the second element of the array. Assume the first element is sorted.
// Iterate over the unsorted portion of the array.
// Compare the current element with the elements in the sorted portion.
// Move the larger elements to the right until the correct position for the current element is found.
// Insert the current element in its correct position within the sorted portion.
// Repeat steps 2-5 until the entire array is sorted.


public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int currentElement = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            arr[j + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        
        insertionSort(arr);
        
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
