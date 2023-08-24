
// Sure, here's the algorithm for the Bubble Sort sorting technique:

// Bubble Sort Algorithm:

// Start with the first element of the array.
// Compare the current element with the next element.
// If the current element is larger than the next element, swap them.
// Move to the next pair of elements and repeat steps 2-3 until the end of the array is reached.
// After the first pass, the largest element will have "bubbled up" to the last position.
// Repeat steps 1-5 for the remaining elements, excluding the last one in each pass.
// Continue this process until the entire array is sorted.



















public class BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                // If no two elements were swapped in the inner loop, the array is already sorted
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        
        bubbleSort(arr);
        
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
