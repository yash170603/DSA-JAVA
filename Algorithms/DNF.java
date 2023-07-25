/*The DNF (Dutch National Flag) algorithm is a sorting algorithm used to sort an array containing three distinct elements,
often represented as 0, 1, and 2. It was named after the Dutch National Flag, which has three horizontal bands of colors.
The algorithm sorts the array in place with linear time complexity.*/

public class DNFAlgorithm {

    public static void dnfSort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 1, 0, 1};
        System.out.println("Original array: " + Arrays.toString(arr));

        dnfSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
