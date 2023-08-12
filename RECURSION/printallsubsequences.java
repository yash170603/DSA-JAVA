import java.util.*;

public class Subsequence2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {3, 1, 2};
        ArrayList<Integer> arr2 = new ArrayList<>();
        int i = 0;
        function(arr, arr2, i);
    }

    public static void function(int[] arr, ArrayList<Integer> arr2, int i) {
        if (i == arr.length) {
            for (int k = 0; k < arr2.size(); k++) {
                System.out.print(arr2.get(k) + " ");
            }
            System.out.println(); // Print a new line after each subsequence
            return;
        }

        arr2.add(arr[i]);
        function(arr, arr2, i + 1);
        arr2.remove(arr2.size() - 1); // Remove the last added element
        function(arr, arr2, i + 1);
    }
}
