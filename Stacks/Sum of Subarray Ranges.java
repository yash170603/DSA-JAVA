import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        long min = sumSubarrayMins(nums);
        long max = sumSubarrayMax(nums);
        return max - min;
    }

    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long d1 = i - NSL[i];
            long d2 = NSR[i] - i;
            
            long totalWaysForIMin = d1 * d2;
            long sumIInTotalWays = arr[i] * totalWaysForIMin;

            sum += sumIInTotalWays;
        }

        return sum;
    }

    public long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] NGL = getNGL(arr, n);
        int[] NGR = getNGR(arr, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long d1 = i - NGL[i];
            long d2 = NGR[i] - i;
            
            long totalWaysForIMax = d1 * d2;
            long sumIInTotalWays = arr[i] * totalWaysForIMax;

            sum += sumIInTotalWays;
        }

        return sum;
    }

    public int[] getNGR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    public int[] getNGL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }
}
