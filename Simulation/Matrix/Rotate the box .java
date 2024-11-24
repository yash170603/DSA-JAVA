class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n= box.length;
        int m = box[0].length;
        char [][] ans = new char[m][n];
        for(int i=0;i<n;i++){
            for( int j=0;j<m;j++){
                     if( box[i][j]=='.'){
                        int k=j;
                          while( k-1>=0 && (    box[i][k-1] != '*')){
                               char temp = box[i][k];
                               box[i][k]=box[i][k-1];
                               box[i][k-1]=temp;
                               k--;
                          }
                     }
            }
        }

        for( int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                  int newj=n-i-1;
                  int newi=j;
                  ans[newi][newj]= box[i][j] ;   

            }
        }


        // for(int i =0;i<m;i++){
        //       System.out.print("row"+i);
        //     for(int j=0;j<n;j++){
              
        //         System.out.print(ans[i][j]);
        //     }
        //     System.out.println(" ");
        // }


        return ans;
    }
}



o(n)
  class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] rotatedBox = new char[m][n];
        
        // Process each row to simulate gravity
        for (int i = 0; i < n; i++) {
            int writePos = m - 1; // Pointer for where the next stone should go
            for (int j = m - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Obstacle: reset the write pointer
                    writePos = j - 1;
                } else if (box[i][j] == '#') {
                    // Stone: move it to the write position
                    box[i][writePos] = '#';
                    if (writePos != j) {
                        box[i][j] = '.'; // Clear the original position
                    }
                    writePos--; // Update the write pointer
                }
            }
        }
        
        // Rotate the matrix by 90 degrees clockwise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedBox[j][n - 1 - i] = box[i][j];
            }
        }
        
        return rotatedBox;
    }
}
