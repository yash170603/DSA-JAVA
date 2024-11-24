class Solution {
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] ans = new int[n][m];
        for (int[] arr : ans) {
            Arrays.fill(arr, -1);
        }

        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int count = 0;
        while (count < n * m && head != null) {
            // Traverse from left to right
            for (int col = left; col <= right && head != null; col++) {
                ans[top][col] = head.val;
                head = head.next;
                count++;
            }
            top++;

            // Traverse from top to bottom
            for (int row = top; row <= bottom && head != null; row++) {
                ans[row][right] = head.val;
                head = head.next;
                count++;
            }
            right--;

            // Traverse from right to left
            for (int col = right; col >= left && head != null; col--) {
                ans[bottom][col] = head.val;
                head = head.next;
                count++;
            }
            bottom--;

            // Traverse from bottom to top
            for (int row = bottom; row >= top && head != null; row--) {
                ans[row][left] = head.val;
                head = head.next;
                count++;
            }
            left++;
        }

        return ans;
    }
}
