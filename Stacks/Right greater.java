import java.util.Stack;

class NextGreaterElementRight {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1; // There is no greater element to the right.
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement(arr);
        for (int nextGreater : result) {
            System.out.print(nextGreater + " ");
        }
    }
}
