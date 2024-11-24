class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
          int n = matrix[0].length;
        int maxRows = 0;

        for (int[] currRow : matrix) {
            int[] inverted = new int[n];
            int count = 0;

            // Generate the inverted row
            for (int col = 0; col < n; col++) {
                inverted[col] = currRow[col] == 0 ? 1 : 0;
            }

            // Count matching rows (either equal to currRow or inverted)
            for (int[] row : matrix) {
                if (Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) {
                    count++;
                }
            }

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}
