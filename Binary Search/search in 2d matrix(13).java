class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = matrix[i].length - 1;
            if (matrix[i][0] <= target && matrix[i][high] >= target) {
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (matrix[i][mid] == target)
                        return true;
                    else if (matrix[i][mid] < target) {
                        low = mid + 1;
                    } else
                        high = mid - 1;
                }
            }

        }

        return false;
    }
}
