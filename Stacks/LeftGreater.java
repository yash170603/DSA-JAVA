import java.util.Stack;

class PreviousGreaterElementLeft {
    public static int[] previousGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1; // There is no greater element to the left.
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = previousGreaterElement(arr);
        for (int prevGreater : result) {
            System.out.print(prevGreater + " ");
        }
    }
}
