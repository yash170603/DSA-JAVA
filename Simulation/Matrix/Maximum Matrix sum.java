class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        long ans=0;
        int negCount=0;
        long least=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                  ans+=Math.abs(matrix[i][j]);
                  if(matrix[i][j]<0){
                    negCount++;
                  }
                  least=Math.min(least,Math.abs(matrix[i][j]));
            }
        }

          if( negCount%2==0L) return ans;

         return ans-2L*least;
    }
}
