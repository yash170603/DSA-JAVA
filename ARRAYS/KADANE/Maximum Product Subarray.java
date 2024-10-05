class Solution {
    public int maxProduct(int[] arr) {
        int prod1 = arr[0], prod2 = arr[0], result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int newp1 = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * arr[i]));  // like -1,8 ,,,, -1 would be both p1 nd p2
            int newp2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));  // like -1,-8 
            prod1 = newp1;
            prod2= newp2;

            result = Math.max(result, prod1);
        }
         return result;
    }
}


// 2nd approach prefix nd suffix 



import java.util.*;

public class tUf {
    public static int maxProductSubArray(int[] arr) {
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer = maxProductSubArray(arr);
        System.out.println("The maximum product subarray is: " + answer);
    }
}

