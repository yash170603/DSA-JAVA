import java.util.Stack;

class PreviousSmallerElementLeft {
    public static int[] previousSmallerElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1; // There is no smaller element to the left.
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = previousSmallerElement(arr);
        for (int prevSmaller : result) {
            System.out.print(prevSmaller + " ");
        }
    }
}
