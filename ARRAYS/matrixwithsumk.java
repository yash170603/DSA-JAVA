class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) 
    {
        int rows= matrix.length;
        int cols = matrix[0].length;
        for( int i=0;i< rows;i++)
        {
            for( int j=1;j<cols;j++)
            {
                matrix[i][j] += matrix[i][j-1];
            }
        }
int result = 0;
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int currCol = startCol; currCol < cols; currCol++) {
                // We need to find all submatrices sum

                // Now comes the concept of "No. of subarrays with sum k"
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                // Go downwards row-wise
                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    if (map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return result;
    }
}
